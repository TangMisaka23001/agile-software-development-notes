package com.agile.change;

import com.agile.affiliation.Affiliation;
import com.agile.affiliation.NoAffiliation;
import com.agile.affiliation.UnionAffiliation;
import com.agile.database.GpayrollDatabase;
import com.agile.employee.Employee;

import java.util.Objects;

/**
 * ChangeUnaffiliatedTransaction
 *
 * @author tangbin
 */
public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {
    public ChangeUnaffiliatedTransaction(int itsEmpId) {
        super(itsEmpId);
    }

    @Override
    public Affiliation getAffiliation() {
        return new NoAffiliation();
    }

    @Override
    public void recordMembership(Employee e) {
        Affiliation af = e.getItsAffiliation();
        UnionAffiliation uf = (UnionAffiliation) af;
        if (Objects.nonNull(uf)) {
            int memberId = uf.getMemberId();
            GpayrollDatabase.removeUnionMember(memberId);
        }
    }
}
