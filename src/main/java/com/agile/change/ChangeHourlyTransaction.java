package com.agile.change;

import com.agile.classification.HourlyClassification;
import com.agile.classification.PaymentClassification;
import com.agile.schedule.PaymentSchedule;
import com.agile.schedule.WeeklySchedule;

/**
 * ChangeHourlyTransaction
 *
 * @author tangbin
 */
public class ChangeHourlyTransaction extends ChangeClassificationTransaction {

    private final double itsHourlyRate;

    public ChangeHourlyTransaction(int itsEmpId, double itsHourlyRate) {
        super(itsEmpId);
        this.itsHourlyRate = itsHourlyRate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new HourlyClassification(this.itsHourlyRate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }
}
