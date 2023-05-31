import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * HourlyClassification
 *
 * @author tangbin
 */
public class HourlyClassification extends PaymentClassification {

    private final Map<Date, TimeCard> timeCardMap = new HashMap<>();

    public TimeCard getTimeCard(Date date) {
        return timeCardMap.get(date);
    }

    public void addTimeCard(TimeCard timeCard) {
        this.timeCardMap.put(timeCard.getDate(), timeCard);
    }
}
