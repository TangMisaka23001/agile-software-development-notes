package com.agile.schedule;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

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
        return itsPayDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).with(LocalTime.MIN);
    }
}
