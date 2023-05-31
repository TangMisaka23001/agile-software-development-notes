package com.agile.change;

import com.agile.database.GpayrollDatabase;
import com.agile.employee.Employee;

import java.util.Objects;

/**
 * ChangeEmployeeTransaction
 *
 * @author tangbin
 */
public abstract class ChangeEmployeeTransaction {

    private int itsEmpId;

    public void execute() {
        Employee e = GpayrollDatabase.getEmployee(itsEmpId);
        if (Objects.nonNull(e)) {
            change(e);
        }
    }

    public abstract void change(Employee employee);

    public ChangeEmployeeTransaction(int itsEmpId) {
        this.itsEmpId = itsEmpId;
    }
}
