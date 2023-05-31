package com.agile.transaction;

import com.agile.classification.PaymentClassification;
import com.agile.database.GpayrollDatabase;
import com.agile.employee.Employee;
import com.agile.method.HoldMethod;
import com.agile.method.PaymentMethod;
import com.agile.schedule.PaymentSchedule;

/**
 * transaction.AddEmployeeTransaction
 *
 * @author tangbin
 */
public class AddEmployeeTransaction extends Transaction {

    private Integer itsEmpId;
    private String itsName;
    private String itsAddress;

    public AddEmployeeTransaction(Integer itsEmpId, String itsName, String itsAddress) {
        this.itsEmpId = itsEmpId;
        this.itsName = itsName;
        this.itsAddress = itsAddress;
    }

    public Integer getItsEmpId() {
        return itsEmpId;
    }

    public void setItsEmpId(Integer itsEmpId) {
        this.itsEmpId = itsEmpId;
    }

    public String getItsAddress() {
        return itsAddress;
    }

    public void setItsAddress(String itsAddress) {
        this.itsAddress = itsAddress;
    }

    public String getItsName() {
        return itsName;
    }

    public void setItsName(String itsName) {
        this.itsName = itsName;
    }

    @Override
    public void execute() {
        PaymentClassification pc = getClassification();
        PaymentSchedule ps = getSchedule();
        PaymentMethod pm = new HoldMethod();
        Employee e = new Employee(itsEmpId, itsName, itsAddress);
        e.setClassification(pc);
        e.setSchedule(ps);
        e.setMethod(pm);
        GpayrollDatabase.addEmployee(itsEmpId, e);
    }

    @Override
    public PaymentClassification getClassification() {
        throw new RuntimeException("must be Override");
    }

    @Override
    public PaymentSchedule getSchedule() {
        throw new RuntimeException("must be Override");
    }
}
