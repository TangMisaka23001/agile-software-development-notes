package com.agile.schedule;

import java.time.LocalDateTime;

/**
 * schedule.PaymentSchedule
 *
 * @author tangbin
 */
public interface PaymentSchedule {

    boolean isPayDate(LocalDateTime date);
}
