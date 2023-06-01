package com.agile.classification;

import com.agile.pay.PayCheck;

import java.time.LocalDateTime;

/**
 * classification.PaymentClassification
 *
 * @author tangbin
 */
public abstract class PaymentClassification {

    public abstract double calculatePay(PayCheck pc);

    public boolean isInPayPeriod(LocalDateTime theDate, PayCheck pc) {
        LocalDateTime payPeriodEndDate = pc.getPayPeriodEndDate();
        LocalDateTime payPeriodStartDate = pc.getPayPeriodStartDate();
        return theDate.isAfter(payPeriodStartDate) && theDate.isBefore(payPeriodEndDate);
    }


}
