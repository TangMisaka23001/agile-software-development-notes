import junit.framework.TestCase;

/**
 * TestAddSalariedEmployee
 *
 * @author tangbin
 */

public class TestAddSalariedEmployee extends TestCase {

    public void testPayrollTest() {
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
}
