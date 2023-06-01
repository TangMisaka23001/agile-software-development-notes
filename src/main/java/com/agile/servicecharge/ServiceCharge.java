package com.agile.servicecharge;

import java.time.LocalDateTime;

/**
 * servicecharge.ServiceCharge
 *
 * @author tangbin
 */
public class ServiceCharge {

    private final LocalDateTime date;
    private final double charge;

    public ServiceCharge(LocalDateTime date, double charge) {
        this.date = date;
        this.charge = charge;
    }

    public double getAmount() {
        return charge;
    }
}
