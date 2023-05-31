package com.agile.affiliation;

import com.agile.servicecharge.ServiceCharge;

import java.util.Date;

/**
 * affiliation.Affiliation
 *
 * @author tangbin
 */
public abstract class Affiliation {
    public abstract ServiceCharge getServiceCharge(Date date);
}
