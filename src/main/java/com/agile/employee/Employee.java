package com.agile.employee;

import com.agile.affiliation.Affiliation;
import com.agile.classification.PaymentClassification;
import com.agile.method.PaymentMethod;
import com.agile.pay.PayCheck;
import com.agile.schedule.PaymentSchedule;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * employee.Employee
 *
 * @author tangbin
 */
public class Employee {

    private Integer empId;
    private String itsName;
    private String itsAddress;
    private PaymentClassification itsClassification;
    private PaymentSchedule itsSchedule;
    private PaymentMethod itsPayMethod;
    private Affiliation itsAffiliation;


    public Employee(Integer empId, String itsName, String itsAddress) {
        this.empId = empId;
        this.itsName = itsName;
        this.itsAddress = itsAddress;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return itsName;
    }

    public void setName(String itsName) {
        this.itsName = itsName;
    }

    public String getAddress() {
        return itsAddress;
    }

    public void setAddress(String itsAddress) {
        this.itsAddress = itsAddress;
    }

    public PaymentClassification getClassification() {
        return itsClassification;
    }

    public void setClassification(PaymentClassification paymentClassification) {
        this.itsClassification = paymentClassification;
    }

    public PaymentSchedule getSchedule() {
        return itsSchedule;
    }

    public void setSchedule(PaymentSchedule paymentSchedule) {
        this.itsSchedule = paymentSchedule;
    }

    public PaymentMethod getMethod() {
        return itsPayMethod;
    }

    public void setMethod(PaymentMethod paymentMethod) {
        this.itsPayMethod = paymentMethod;
    }

    public Affiliation getItsAffiliation() {
        return itsAffiliation;
    }

    public void setItsAffiliation(Affiliation itsAffiliation) {
        this.itsAffiliation = itsAffiliation;
    }

    public void payday(PayCheck pc) {
        double grossPay = itsClassification.calculatePay(pc);
        if (Objects.nonNull(itsAffiliation)) {
            double deductions = itsAffiliation.calculateDeductions(pc);
            double netPay = grossPay - deductions;
            pc.setDeductions(deductions);
            pc.setNetPay(netPay);
        } else {
            pc.setDeductions(0);
            pc.setNetPay(grossPay);
        }
        pc.setGrossPay(grossPay);
        itsPayMethod.pay(pc);
    }

    public boolean isPayDate(LocalDateTime itsPayDate) {
        return itsSchedule.isPayDate(itsPayDate);
    }

    public LocalDateTime getPayPeriodStartDate(LocalDateTime itsPayDate) {
        return itsSchedule.getPayPeriodStartDate(itsPayDate);
    }
}
