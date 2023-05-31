package com.agile.employee;

import com.agile.classification.HourlyClassification;
import com.agile.classification.PaymentClassification;
import com.agile.schedule.PaymentSchedule;
import com.agile.schedule.WeeklySchedule;
import com.agile.transaction.AddEmployeeTransaction;

/**
 * employee.AddHourlyEmployee
 *
 * @author tangbin
 */
public class AddHourlyEmployee extends AddEmployeeTransaction {

    private Double hourlyRate;

    public AddHourlyEmployee(Integer itsEmpId, String itsName, String itsAddress, Double hourlyRate) {
        super(itsEmpId, itsName, itsAddress);
        this.hourlyRate = hourlyRate;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void execute() {
        super.execute();
    }

    @Override
    public PaymentClassification getClassification() {
        return new HourlyClassification(this.hourlyRate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }
}
