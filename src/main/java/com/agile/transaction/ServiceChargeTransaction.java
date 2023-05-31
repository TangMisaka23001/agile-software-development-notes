package com.agile.transaction;

import com.agile.affiliation.Affiliation;
import com.agile.affiliation.UnionAffiliation;
import com.agile.database.GpayrollDatabase;
import com.agile.employee.Employee;

import java.util.Date;
import java.util.Objects;

/**
 * transaction.ServiceChargeTransaction
 *
 * @author tangbin
 */
public class ServiceChargeTransaction extends Transaction {

    private final int itsMemberId;
    private final Date itsDate;
    private final double itsCharge;

    public ServiceChargeTransaction(int itsMemberId, Date itsDate, double itsCharge) {
        this.itsMemberId = itsMemberId;
        this.itsDate = itsDate;
        this.itsCharge = itsCharge;
    }

    @Override
    public void execute() {
        Employee e = GpayrollDatabase.getUnionMember(itsMemberId);
        Affiliation af = e.getItsAffiliation();
        UnionAffiliation uaf = (UnionAffiliation) af;
        if (Objects.nonNull(uaf)) {
            uaf.addServiceCharge(itsDate, itsCharge);
        }
    }
}
