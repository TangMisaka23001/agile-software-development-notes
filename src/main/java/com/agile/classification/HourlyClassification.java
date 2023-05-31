package com.agile.classification;

import com.agile.pay.PayCheck;
import com.agile.timecard.TimeCard;

import java.time.LocalDateTime;
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

    private final Map<LocalDateTime, TimeCard> timeCardMap = new HashMap<>();

    public TimeCard getTimeCard(LocalDateTime date) {
        return timeCardMap.get(date);
    }

    public void addTimeCard(TimeCard timeCard) {
        this.timeCardMap.put(timeCard.getDate(), timeCard);
    }

    public double getRate() {
        return itsHourlyRate;
    }

    @Override
    public double calculatePay(PayCheck pc) {
        return this.timeCardMap.values().stream().mapToDouble(card -> {
            double cardHours = card.getHours();
            double hours = cardHours <= 8 ? cardHours : (8 + (cardHours - 8) * 1.5);
            return this.itsHourlyRate * hours;
        }).sum();
    }
}
