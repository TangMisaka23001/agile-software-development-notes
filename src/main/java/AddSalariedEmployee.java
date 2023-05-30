/**
 * AddSalarledEmployee
 *
 * @author tangbin
 */
public class AddSalariedEmployee extends AddEmployeeTransaction {

    private Double itsSalary;

    public AddSalariedEmployee(Integer empId, String itsName, String itsAddress, Double itsSalary) {
        super(empId, itsName, itsAddress);
        this.itsSalary = itsSalary;
    }

    public Double getItsSalary() {
        return itsSalary;
    }

    public void setItsSalary(Double itsSalary) {
        this.itsSalary = itsSalary;
    }

    @Override
    PaymentClassification getClassification() {
        return new SalariedClassification(itsSalary);
    }

    @Override
    PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }
}
