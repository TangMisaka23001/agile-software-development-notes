package com.agile.pay;

import java.time.LocalDateTime;

/**
 * PayCheck
 *
 * @author tangbin
 */
public class PayCheck {

    private double grossPay;

    private double deductions;

    private double netPay;

    private LocalDateTime itsPayDate;
    private final LocalDateTime itsPayStartDate;

    public PayCheck(LocalDateTime itsPayStartDate, LocalDateTime itsPayDate) {
        this.itsPayDate = itsPayDate;
        this.itsPayStartDate = itsPayStartDate;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    public LocalDateTime getPayDate() {
        return itsPayDate;
    }

    public void setPayDate(LocalDateTime itsPayDate) {
        this.itsPayDate = itsPayDate;
    }

    public String getField(String disposition) {
        return "Hold";
    }

    public LocalDateTime getPayPeriodEndDate() {
        return itsPayDate;
    }

    public LocalDateTime getPayPeriodStartDate() {
        return itsPayStartDate;
    }
}
