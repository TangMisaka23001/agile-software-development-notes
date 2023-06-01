package com.agile.affiliation;

import com.agile.pay.PayCheck;
import com.agile.servicecharge.ServiceCharge;

import java.time.LocalDateTime;

/**
 * NoAffiliation
 *
 * @author tangbin
 */
public class NoAffiliation extends Affiliation {
    @Override
    public ServiceCharge getServiceCharge(LocalDateTime date) {
        return null;
    }

    @Override
    public double calculateDeductions(PayCheck pc) {
        return 0;
    }
}
