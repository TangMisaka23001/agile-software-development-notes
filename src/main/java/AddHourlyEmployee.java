/**
 * AddHourlyEmployee
 *
 * @author tangbin
 */
public class AddHourlyEmployee extends AddEmployeeTransaction {

    private Double hourlyRate;

    public AddHourlyEmployee(Integer itsEmpId, String itsAddress, String itsName) {
        super(itsEmpId, itsAddress, itsName);
    }
}
