package com.agile.transaction;

import com.agile.classification.PaymentClassification;
import com.agile.database.GpayrollDatabase;
import com.agile.schedule.PaymentSchedule;

/**
 * transaction.DeleteEmployeeTransaction
 *
 * @author tangbin
 */
public class DeleteEmployeeTransaction extends Transaction {

    private int itsEmpId;

    public DeleteEmployeeTransaction(int itsEmpId) {
        this.itsEmpId = itsEmpId;
    }

    @Override
    public void execute() {
        GpayrollDatabase.deleteEmployee(itsEmpId);
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
