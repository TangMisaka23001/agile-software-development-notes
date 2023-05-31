import java.util.Date;

/**
 * UnionAffiliation
 *
 * @author tangbin
 */
public class UnionAffiliation extends Affiliation {

    private ServiceCharge serviceCharge;
    private int memberId;
    private double charge;

    public void addServiceCharge(Date date, double charge) {
        this.serviceCharge = new ServiceCharge(date, charge);
    }

    public UnionAffiliation(int memberId, double charge) {
        this.memberId = memberId;
        this.charge = charge;
    }

    @Override
    ServiceCharge getServiceCharge(Date date) {
        return serviceCharge;
    }
}
