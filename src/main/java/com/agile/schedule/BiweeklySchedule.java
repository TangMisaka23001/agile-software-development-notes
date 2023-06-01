package com.agile.schedule;

import java.time.LocalDateTime;

/**
 * BlweeklySchedule
 *
 * @author tangbin
 */
public class BiweeklySchedule implements PaymentSchedule {
    @Override
    public boolean isPayDate(LocalDateTime date) {
        return false;
    }

    @Override
    public LocalDateTime getPayPeriodStartDate(LocalDateTime itsPayDate) {
        return null;
    }
}
