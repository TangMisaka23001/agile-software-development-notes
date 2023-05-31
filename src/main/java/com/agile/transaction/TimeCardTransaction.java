package com.agile.transaction;

import com.agile.classification.HourlyClassification;
import com.agile.classification.PaymentClassification;
import com.agile.database.GpayrollDatabase;
import com.agile.employee.Employee;
import com.agile.schedule.PaymentSchedule;
import com.agile.timecard.TimeCard;

import java.util.Date;
import java.util.Objects;

/**
 * transaction.TimeCardTransaction
 *
 * @author tangbin
 */
public class TimeCardTransaction extends Transaction {

    private Date itsDate;
    private Double itsHours;
    private Integer itsEmpId;

    public TimeCardTransaction(Date itsDate, Double itsHours, Integer itsEmpId) {
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

    @Override
    public PaymentClassification getClassification() {
        return null;
    }

    @Override
    public PaymentSchedule getSchedule() {
        return null;
    }
}
