package com.agile.change;

import com.agile.employee.Employee;

/**
 * ChangeNameTransaction
 *
 * @author tangbin
 */
public class ChangeNameTransaction extends ChangeEmployeeTransaction {

    private String itsName;

    public ChangeNameTransaction(int itsEmpId, String itsName) {
        super(itsEmpId);
        this.itsName = itsName;
    }

    @Override
    public void change(Employee e) {
        e.setName(itsName);
    }
}
