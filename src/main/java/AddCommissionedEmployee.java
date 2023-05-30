/**
 * AddCommissionedEmployee
 *
 * @author tangbin
 */
public class AddCommissionedEmployee extends AddEmployeeTransaction {

    private String salary;
    private Double commissionRate;

    public AddCommissionedEmployee(Integer itsEmpId, String itsAddress, String itsName) {
        super(itsEmpId, itsAddress, itsName);
    }
}
