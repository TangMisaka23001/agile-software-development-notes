package com.agile.employee;

import com.agile.classification.PaymentClassification;
import com.agile.schedule.PaymentSchedule;
import com.agile.transaction.AddEmployeeTransaction;

/**
 * employee.AddCommissionedEmployee
 *
 * @author tangbin
 */
public class AddCommissionedEmployee extends AddEmployeeTransaction {

    private Integer salary;
    private Double commissionRate;

    public AddCommissionedEmployee(Integer itsEmpId, String itsName, String itsAddress, Integer salary, Double commissionRate) {
        super(itsEmpId, itsName, itsAddress);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
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
