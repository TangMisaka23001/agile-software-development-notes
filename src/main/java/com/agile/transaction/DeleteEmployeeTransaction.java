package com.agile.transaction;

import com.agile.database.GpayrollDatabase;

/**
 * transaction.DeleteEmployeeTransaction
 *
 * @author tangbin
 */
public class DeleteEmployeeTransaction extends Transaction {

    private final int itsEmpId;

    public DeleteEmployeeTransaction(int itsEmpId) {
        this.itsEmpId = itsEmpId;
    }

    @Override
    public void execute() {
        GpayrollDatabase.deleteEmployee(itsEmpId);
    }

}
