package com.agile.schedule;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoField.MONTH_OF_YEAR;

/**
 * schedule.MonthlySchedule
 *
 * @author tangbin
 */
public class MonthlySchedule implements PaymentSchedule {

    public static boolean isLastDayOfMonth(LocalDateTime date) {
        int m1 = date.getMonth().get(MONTH_OF_YEAR);
        int m2 = date.plusDays(1).getMonth().get(MONTH_OF_YEAR);
        return m1 != m2;
    }

    @Override
    public boolean isPayDate(LocalDateTime date) {
        return isLastDayOfMonth(date);
    }
}
