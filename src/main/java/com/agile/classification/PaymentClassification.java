package com.agile.classification;

import com.agile.pay.PayCheck;

/**
 * classification.PaymentClassification
 *
 * @author tangbin
 */
public abstract class PaymentClassification {

    public abstract double calculatePay(PayCheck pc);
}
