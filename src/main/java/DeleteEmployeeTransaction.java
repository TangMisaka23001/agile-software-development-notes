/**
 * DeleteEmployeeTransaction
 *
 * @author tangbin
 */
public class DeleteEmployeeTransaction extends Transaction {

    private int itsEmpId;

    public DeleteEmployeeTransaction(int itsEmpId) {
        this.itsEmpId = itsEmpId;
    }

    @Override
    void execute() {
        GpayrollDatabase.deleteEmployee(itsEmpId);
    }

    @Override
    PaymentClassification getClassification() {
        return null;
    }

    @Override
    PaymentSchedule getSchedule() {
        return null;
    }
}
