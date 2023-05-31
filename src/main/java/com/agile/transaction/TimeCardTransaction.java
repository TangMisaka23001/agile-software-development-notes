package com.agile.transaction;

import com.agile.classification.HourlyClassification;
import com.agile.classification.PaymentClassification;
import com.agile.database.GpayrollDatabase;
import com.agile.employee.Employee;
import com.agile.timecard.TimeCard;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * transaction.TimeCardTransaction
 *
 * @author tangbin
 */
public class TimeCardTransaction extends Transaction {

    private final LocalDateTime itsDate;
    private final Double itsHours;
    private final Integer itsEmpId;

    public TimeCardTransaction(LocalDateTime itsDate, Double itsHours, Integer itsEmpId) {
        this.itsDate = itsDate;
        this.itsHours = itsHours;
        this.itsEmpId = itsEmpId;
    }

    @Override
    public void execute() {
        Employee e = GpayrollDatabase.getEmployee(itsEmpId);
        if (Objects.nonNull(e)) {
            PaymentClassification pc = e.getClassification();
            HourlyClassification hc = (HourlyClassification) pc;
            if (Objects.nonNull(hc)) {
                hc.addTimeCard(new TimeCard(itsDate, itsHours));
            } else {
                throw new RuntimeException("Tried to add timecard to non-hourly employee");
            }
        } else {
            throw new RuntimeException("No such employee.");
        }
    }
}
