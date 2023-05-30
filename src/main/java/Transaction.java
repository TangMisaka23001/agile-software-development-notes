/**
 * Transaction
 *
 * @author tangbin
 */
public abstract class Transaction {

    abstract void execute();

    abstract PaymentClassification getClassification();

    abstract PaymentSchedule getSchedule();
}
