package com.agile.change;

import com.agile.affiliation.Affiliation;
import com.agile.employee.Employee;

/**
 * ChangeAffiliationTransaction
 *
 * @author tangbin
 */
public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {

    public ChangeAffiliationTransaction(int itsEmpId) {
        super(itsEmpId);
    }

    @Override
    public void change(Employee e) {
        recordMembership(e);
        e.setAffiliation(getAffiliation());
    }

    public abstract Affiliation getAffiliation();

    public abstract void recordMembership(Employee e);
}
