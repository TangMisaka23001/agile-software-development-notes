package com.agile.affiliation;

import com.agile.pay.PayCheck;
import com.agile.servicecharge.ServiceCharge;

import java.util.Date;

/**
 * affiliation.Affiliation
 *
 * @author tangbin
 */
public abstract class Affiliation {
    public abstract ServiceCharge getServiceCharge(Date date);

    public double calculateDeductions(PayCheck pc) {
        return 0;
    }
}
