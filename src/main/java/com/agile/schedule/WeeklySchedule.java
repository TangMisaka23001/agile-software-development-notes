package com.agile.schedule;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * schedule.WeeklySchedule
 *
 * @author tangbin
 */
public class WeeklySchedule implements PaymentSchedule {
    @Override
    public boolean isPayDate(LocalDateTime date) {
        return date.getDayOfWeek() == DayOfWeek.FRIDAY;
    }

    @Override
    public LocalDateTime getPayPeriodStartDate(LocalDateTime itsPayDate) {
        return null;
    }
}
