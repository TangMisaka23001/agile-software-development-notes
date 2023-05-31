package com.agile.affiliation;

import com.agile.servicecharge.ServiceCharge;

import java.util.Date;

/**
 * NoAffiliation
 *
 * @author tangbin
 */
public class NoAffiliation extends Affiliation {
    @Override
    public ServiceCharge getServiceCharge(Date date) {
        return null;
    }
}
