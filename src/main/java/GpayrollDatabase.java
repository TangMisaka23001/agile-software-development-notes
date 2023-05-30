import java.util.HashMap;
import java.util.Map;

/**
 * PayrollDatabase
 *
 * @author tangbin
 */
public class GpayrollDatabase {

    private static final Map<Integer, Employee> itsEmployees = new HashMap<>();

    public static Employee getEmployee(int empId) {
        return itsEmployees.get(empId);
    }

    public static void addEmployee(int empId, Employee employee) {
        itsEmployees.put(empId, employee);
    }

    public static void deleteEmployee(int empId) {
        itsEmployees.remove(empId);
    }

    public static void clear() {
        itsEmployees.clear();
    }
}
