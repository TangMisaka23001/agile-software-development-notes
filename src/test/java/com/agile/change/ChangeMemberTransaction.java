package com.agile.change;

import com.agile.affiliation.Affiliation;
import com.agile.affiliation.UnionAffiliation;
import com.agile.database.GpayrollDatabase;
import com.agile.employee.Employee;

/**
 * ChangeMemberTransaction
 *
 * @author tangbin
 */
public class ChangeMemberTransaction extends ChangeAffiliationTransaction {

    private final int itsMemberId;
    private final double itsDues;

    public ChangeMemberTransaction(int itsEmpId, int itsMemberId, double itsDues) {
        super(itsEmpId);
        this.itsMemberId = itsMemberId;
        this.itsDues = itsDues;
    }

    @Override
    public Affiliation getAffiliation() {
        return new UnionAffiliation(itsMemberId, itsDues);
    }

    @Override
    public void recordMembership(Employee e) {
        GpayrollDatabase.addUnionMember(itsMemberId, e);
    }
}
