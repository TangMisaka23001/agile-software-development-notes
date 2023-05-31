package com.agile.transaction;

import com.agile.classification.PaymentClassification;
import com.agile.schedule.PaymentSchedule;

/**
 * transaction.Transaction
 *
 * @author tangbin
 */
public abstract class Transaction {

    public abstract void execute();

    public abstract PaymentClassification getClassification();

    public abstract PaymentSchedule getSchedule();
}
