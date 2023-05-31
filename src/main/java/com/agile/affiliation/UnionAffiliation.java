package com.agile.affiliation;

import com.agile.servicecharge.ServiceCharge;

import java.util.Date;

/**
 * affiliation.UnionAffiliation
 *
 * @author tangbin
 */
public class UnionAffiliation extends Affiliation {

    private ServiceCharge serviceCharge;
    private final int memberId;
    private final double dues;

    public void addServiceCharge(Date date, double charge) {
        this.serviceCharge = new ServiceCharge(date, charge);
    }

    public UnionAffiliation(int memberId, double dues) {
        this.memberId = memberId;
        this.dues = dues;
    }

    @Override
    public ServiceCharge getServiceCharge(Date date) {
        return serviceCharge;
    }

    public int getMemberId() {
        return memberId;
    }

    public double getDues() {
        return dues;
    }
}
