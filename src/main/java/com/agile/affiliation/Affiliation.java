package com.agile.affiliation;

import com.agile.pay.PayCheck;
import com.agile.servicecharge.ServiceCharge;

import java.time.LocalDateTime;

/**
 * affiliation.Affiliation
 *
 * @author tangbin
 */
public abstract class Affiliation {
    public abstract ServiceCharge getServiceCharge(LocalDateTime date);

    public abstract double calculateDeductions(PayCheck pc);
}
