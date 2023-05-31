package com.agile.classification;

import com.agile.timecard.TimeCard;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * classification.HourlyClassification
 *
 * @author tangbin
 */
public class HourlyClassification extends PaymentClassification {

    private final double itsHourlyRate;

    public HourlyClassification(double itsHourlyRate) {
        this.itsHourlyRate = itsHourlyRate;
    }

    private final Map<Date, TimeCard> timeCardMap = new HashMap<>();

    public TimeCard getTimeCard(Date date) {
        return timeCardMap.get(date);
    }

    public void addTimeCard(TimeCard timeCard) {
        this.timeCardMap.put(timeCard.getDate(), timeCard);
    }

    public double getRate() {
        return itsHourlyRate;
    }
}
