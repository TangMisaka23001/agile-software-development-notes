package com.agile.transaction;

import com.agile.affiliation.Affiliation;
import com.agile.affiliation.UnionAffiliation;
import com.agile.classification.PaymentClassification;
import com.agile.database.GpayrollDatabase;
import com.agile.employee.Employee;
import com.agile.schedule.PaymentSchedule;

import java.util.Date;
import java.util.Objects;

/**
 * transaction.ServiceChargeTransaction
 *
 * @author tangbin
 */
public class ServiceChargeTransaction extends Transaction {

    private int itsMemberId;
    private Date itsDate;
    private double itsCharge;

    public ServiceChargeTransaction(int itsMemberId, Date itsDate, double itsCharge) {
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

    @Override
    public PaymentClassification getClassification() {
        return null;
    }

    @Override
    public PaymentSchedule getSchedule() {
        return null;
    }
}
