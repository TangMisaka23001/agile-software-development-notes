/**
 * Employee
 *
 * @author tangbin
 */
public class Employee {

    private Integer empId;
    private String itsName;
    private String itsAddress;
    private PaymentClassification paymentClassification;
    private PaymentSchedule paymentSchedule;
    private PaymentMethod paymentMethod;


    public Employee(Integer empId, String itsName, String itsAddress) {
        this.empId = empId;
        this.itsName = itsName;
        this.itsAddress = itsAddress;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return itsName;
    }

    public void setName(String itsName) {
        this.itsName = itsName;
    }

    public String getAddress() {
        return itsAddress;
    }

    public void setAddress(String itsAddress) {
        this.itsAddress = itsAddress;
    }

    public PaymentClassification getClassification() {
        return paymentClassification;
    }

    public void setClassification(PaymentClassification paymentClassification) {
        this.paymentClassification = paymentClassification;
    }

    public PaymentSchedule getSchedule() {
        return paymentSchedule;
    }

    public void setSchedule(PaymentSchedule paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public PaymentMethod getMethod() {
        return paymentMethod;
    }

    public void setMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
