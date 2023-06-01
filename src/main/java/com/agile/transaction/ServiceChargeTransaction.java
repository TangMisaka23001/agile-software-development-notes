package com.agile.transaction;

import com.agile.affiliation.Affiliation;
import com.agile.affiliation.UnionAffiliation;
import com.agile.database.GpayrollDatabase;
import com.agile.employee.Employee;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * transaction.ServiceChargeTransaction
 *
 * @author tangbin
 */
public class ServiceChargeTransaction extends Transaction {

    private final int itsMemberId;
    private final LocalDateTime itsDate;
    private final double itsCharge;

    public ServiceChargeTransaction(int itsMemberId, LocalDateTime itsDate, double itsCharge) {
        this.itsMemberId = itsMemberId;
        this.itsDate = itsDate;
        this.itsCharge = itsCharge;
    }

    @Override
    public void execute() {
        Employee e = GpayrollDatabase.getUnionMember(itsMemberId);
        Affiliation af = e.getAffiliation();
        UnionAffiliation uaf = (UnionAffiliation) af;
        if (Objects.nonNull(uaf)) {
            uaf.addServiceCharge(itsDate, itsCharge);
        }
    }
}
