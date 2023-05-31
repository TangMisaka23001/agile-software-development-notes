package com.agile.timecard;

import java.time.LocalDateTime;

/**
 * timecard.TimeCard
 *
 * @author tangbin
 */
public class TimeCard {

    private final LocalDateTime itsDate;
    private final Double itsHours;

    public double getHours() {
        return this.itsHours;
    }

    public TimeCard(LocalDateTime itsDate, Double itsHours) {
        this.itsDate = itsDate;
        this.itsHours = itsHours;
    }

    public LocalDateTime getDate() {
        return itsDate;
    }
}
