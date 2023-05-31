import java.util.Date;
import java.util.Objects;

/**
 * ServiceChargeTransaction
 *
 * @author tangbin
 */
public class ServiceChargeTransaction extends Transaction {

    private int itsMemberId;
    private Date itsDate;
    private double itsCharge;

    public ServiceChargeTransaction(int itsMemberId, Date itsDate, double itsCharge) {
        this.itsMemberId = itsMemberId;
        this.itsDate = itsDate;
        this.itsCharge = itsCharge;
    }

    @Override
    void execute() {
        Employee e = GpayrollDatabase.getUnionMember(itsMemberId);
        Affiliation af = e.getAffiliation();
        UnionAffiliation uaf = (UnionAffiliation) af;
        if (Objects.nonNull(uaf)) {
            uaf.addServiceCharge(itsDate, itsCharge);
        }
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
