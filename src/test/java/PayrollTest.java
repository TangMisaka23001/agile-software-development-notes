import junit.framework.TestCase;

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
}
