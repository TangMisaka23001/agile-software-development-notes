import junit.framework.TestCase;

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
}
