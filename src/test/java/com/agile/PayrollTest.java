package com.agile;

import com.agile.affiliation.Affiliation;
import com.agile.affiliation.UnionAffiliation;
import com.agile.change.ChangeHourlyTransaction;
import com.agile.change.ChangeMemberTransaction;
import com.agile.change.ChangeNameTransaction;
import com.agile.classification.HourlyClassification;
import com.agile.classification.PaymentClassification;
import com.agile.classification.SalariedClassification;
import com.agile.database.GpayrollDatabase;
import com.agile.employee.AddCommissionedEmployee;
import com.agile.employee.AddHourlyEmployee;
import com.agile.employee.AddSalariedEmployee;
import com.agile.employee.Employee;
import com.agile.method.HoldMethod;
import com.agile.method.PaymentMethod;
import com.agile.pay.PayCheck;
import com.agile.schedule.MonthlySchedule;
import com.agile.schedule.PaymentSchedule;
import com.agile.schedule.WeeklySchedule;
import com.agile.servicecharge.ServiceCharge;
import com.agile.timecard.TimeCard;
import com.agile.transaction.DeleteEmployeeTransaction;
import com.agile.transaction.PaydayTransaction;
import com.agile.transaction.ServiceChargeTransaction;
import com.agile.transaction.TimeCardTransaction;
import junit.framework.TestCase;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * TestAddSalariedEmployee
 *
 * @author tangbin
 */

public class PayrollTest extends TestCase {

    public void testAddSalariedEmployee() {
        int empId = 1;

        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
        t.execute();

        Employee e = GpayrollDatabase.getEmployee(empId);
        assertEquals("Bob", e.getName());

        PaymentClassification pc = e.getClassification();

        SalariedClassification sc = (SalariedClassification) pc;
        assertNotNull(sc);

        assertEquals(1000.00, sc.getSalary());
        PaymentSchedule ps = e.getSchedule();
        MonthlySchedule ms = (MonthlySchedule) ps;
        assertNotNull(ms);

        PaymentMethod pm = e.getMethod();
        HoldMethod hm = (HoldMethod) pm;
        assertNotNull(hm);
    }

    public void testDeleteEmployee() {
        int empId = 3;

        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2);
        t.execute();
        {
            Employee e = GpayrollDatabase.getEmployee(empId);
            assertNotNull(e);
        }
        DeleteEmployeeTransaction dt = new DeleteEmployeeTransaction(empId);
        dt.execute();
        {
            Employee e = GpayrollDatabase.getEmployee(empId);
            assertNull(e);
        }
    }

    public void testTimeCardTransaction() {
        int empId = 2;

        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        TimeCardTransaction tct = new TimeCardTransaction(new Date(2001, 10, 31), 8.0, empId);
        tct.execute();

        Employee e = GpayrollDatabase.getEmployee(empId);
        assertNotNull(e);

        PaymentClassification pc = e.getClassification();
        HourlyClassification hc = (HourlyClassification) pc;
        assertNotNull(hc);

        TimeCard tc = hc.getTimeCard(new Date(2001, 10, 31));
        assertNotNull(tc);
        assertEquals(8.0, tc.getHours());
    }

    public void testAddServiceCharge() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        Employee e = GpayrollDatabase.getEmployee(empId);
        assertNotNull(e);

        int memberId = 86;
        UnionAffiliation af = new UnionAffiliation(memberId, 12.95);
        e.setItsAffiliation(af);
        GpayrollDatabase.addUnionMember(memberId, e);
        ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, new Date(2001, 11, 01), 12.95);
        sct.execute();

        ServiceCharge sc = af.getServiceCharge(new Date(2001, 11, 01));
        assertNotNull(sc);
        assertEquals(12.95, sc.getAmount());
    }

    public void testChangeNameTransaction() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        ChangeNameTransaction cnt = new ChangeNameTransaction(empId, "Bob");
        cnt.execute();

        Employee e = GpayrollDatabase.getEmployee(empId);
        assertNotNull(e);
        assertEquals("Bob", e.getName());
    }

    public void testChangeHourlyTransaction() {
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2);
        t.execute();

        ChangeHourlyTransaction cht = new ChangeHourlyTransaction(empId, 27.52);
        cht.execute();

        Employee e = GpayrollDatabase.getEmployee(empId);
        assertNotNull(e);
        PaymentClassification pc = e.getClassification();
        assertNotNull(pc);
        HourlyClassification hc = (HourlyClassification) pc;
        assertNotNull(hc);
        assertEquals(27.52, hc.getRate());
        PaymentSchedule ps = e.getSchedule();
        WeeklySchedule ws = (WeeklySchedule) ps;
        assertNotNull(ws);
    }

    public void testChangeMemberTransaction() {
        int empId = 2;
        int memberId = 7734;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();
        ChangeMemberTransaction cmt = new ChangeMemberTransaction(empId, memberId, 99.42);
        cmt.execute();

        Employee e = GpayrollDatabase.getEmployee(empId);
        assertNotNull(e);

        Affiliation af = e.getItsAffiliation();
        assertNotNull(af);
        UnionAffiliation uf = (UnionAffiliation) af;
        assertNotNull(uf);
        assertEquals(99.42, uf.getDues());
        Employee member = GpayrollDatabase.getUnionMember(memberId);
        assertNotNull(member);
        assertEquals(e, member);
    }

    public void testPaySingleSalariedEmployee() {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
        t.execute();
        LocalDateTime payDate = LocalDateTime.of(2001, 11, 30, 0, 0);
        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        PayCheck pc = pt.getPayCheck(empId);
        assertNotNull(pc);
        assertEquals(pc.getPayDate(), payDate);
        assertEquals(1000.00, pc.getGrossPay());
        assertEquals("Hoid", pc.getField("Disposition"));
        assertEquals(0.0, pc.getDeductions());
        assertEquals(1000.00, pc.getNetPay());
    }

    public void testPaySingleSalariedEmployeeOnWrongDate() {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
        t.execute();
        LocalDateTime payDate = LocalDateTime.of(2001, 11, 29, 0, 0);
        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        PayCheck pc = pt.getPayCheck(empId);
        assertNull(pc);
    }

}
