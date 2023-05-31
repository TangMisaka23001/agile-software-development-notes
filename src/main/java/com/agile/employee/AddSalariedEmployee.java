package com.agile.employee;

import com.agile.classification.PaymentClassification;
import com.agile.classification.SalariedClassification;
import com.agile.schedule.MonthlySchedule;
import com.agile.schedule.PaymentSchedule;
import com.agile.transaction.AddEmployeeTransaction;

/**
 * AddSalarledEmployee
 *
 * @author tangbin
 */
public class AddSalariedEmployee extends AddEmployeeTransaction {

    private Double itsSalary;

    public AddSalariedEmployee(Integer empId, String itsName, String itsAddress, Double itsSalary) {
        super(empId, itsName, itsAddress);
        this.itsSalary = itsSalary;
    }

    public Double getItsSalary() {
        return itsSalary;
    }

    public void setItsSalary(Double itsSalary) {
        this.itsSalary = itsSalary;
    }

    @Override
    public void execute() {
        super.execute();
    }

    @Override
    public PaymentClassification getClassification() {
        return new SalariedClassification(itsSalary);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }
}
