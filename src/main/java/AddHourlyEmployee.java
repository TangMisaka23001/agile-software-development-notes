/**
 * AddHourlyEmployee
 *
 * @author tangbin
 */
public class AddHourlyEmployee extends AddEmployeeTransaction {

    private Double hourlyRate;

    public AddHourlyEmployee(Integer itsEmpId, String itsName, String itsAddress, Double hourlyRate) {
        super(itsEmpId, itsName, itsAddress);
        this.hourlyRate = hourlyRate;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    PaymentClassification getClassification() {
        return new HourlyClassification();
    }

    @Override
    PaymentSchedule getSchedule() {
        return null;
    }
}
