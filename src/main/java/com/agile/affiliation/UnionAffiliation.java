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
    private int memberId;
    private double charge;

    public void addServiceCharge(Date date, double charge) {
        this.serviceCharge = new ServiceCharge(date, charge);
    }

    public UnionAffiliation(int memberId, double charge) {
        this.memberId = memberId;
        this.charge = charge;
    }

    @Override
    public ServiceCharge getServiceCharge(Date date) {
        return serviceCharge;
    }
}
