/**
 * AddCommissionedEmployee
 *
 * @author tangbin
 */
public class AddCommissionedEmployee extends AddEmployeeTransaction {

    private Integer salary;
    private Double commissionRate;

    public AddCommissionedEmployee(Integer itsEmpId, String itsName, String itsAddress, Integer salary, Double commissionRate) {
        super(itsEmpId, itsName, itsAddress);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }
}
