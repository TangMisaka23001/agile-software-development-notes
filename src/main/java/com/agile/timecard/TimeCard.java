package com.agile.timecard;

import java.util.Date;

/**
 * timecard.TimeCard
 *
 * @author tangbin
 */
public class TimeCard {

    private Date itsDate;
    private Double itsHours;

    public double getHours() {
        return this.itsHours;
    }

    public Date getDate() {
        return itsDate;
    }

    public TimeCard(Date itsDate, Double itsHours) {
        this.itsDate = itsDate;
        this.itsHours = itsHours;
    }
}
