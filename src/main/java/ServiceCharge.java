import java.util.Date;

/**
 * ServiceCharge
 *
 * @author tangbin
 */
public class ServiceCharge {

    private Date date;
    private double charge;

    public ServiceCharge(Date date, double charge) {
        this.date = date;
        this.charge = charge;
    }

    public double getAmount() {
        return charge;
    }
}
