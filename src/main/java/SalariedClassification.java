/**
 * SalariedClassification
 *
 * @author tangbin
 */
public class SalariedClassification extends PaymentClassification {

    private Double itsSalary;

    public SalariedClassification(Double itsSalary) {
        this.itsSalary = itsSalary;
    }

    public Double getSalary() {
        return itsSalary;
    }

    public void setSalary(Double itsSalary) {
        this.itsSalary = itsSalary;
    }
}
