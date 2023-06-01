package com.agile.affiliation;

import com.agile.pay.PayCheck;
import com.agile.servicecharge.ServiceCharge;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Objects;

/**
 * affiliation.UnionAffiliation
 *
 * @author tangbin
 */
public class UnionAffiliation extends Affiliation {

    private ServiceCharge serviceCharge;
    private final int memberId;
    private final double itsDues;

    public void addServiceCharge(LocalDateTime date, double charge) {
        this.serviceCharge = new ServiceCharge(date, charge);
    }

    public UnionAffiliation(int memberId, double itsDues) {
        this.memberId = memberId;
        this.itsDues = itsDues;
    }

    @Override
    public ServiceCharge getServiceCharge(LocalDateTime date) {
        return serviceCharge;
    }

    public int getMemberId() {
        return memberId;
    }

    public double getDues() {
        return itsDues;
    }

    private int numberOfFridaysInPayPeriod(LocalDateTime payPeriodStart, LocalDateTime payPeriodEnd) {
        int count = payPeriodEnd.getDayOfWeek() == DayOfWeek.FRIDAY ? 1 : 0;
        LocalDateTime current = payPeriodStart;
        while (current.isBefore(payPeriodEnd)) {
            LocalDateTime nextFriday = current.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
            if (nextFriday.toLocalDate().isEqual(current.toLocalDate())) {
                count++;
            }
            current = current.plusDays(1);
        }
        return count;
    }

    @Override
    public double calculateDeductions(PayCheck pc) {
        int fridays = numberOfFridaysInPayPeriod(pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate());
        return itsDues * fridays + (Objects.nonNull(serviceCharge) ? serviceCharge.getAmount() : 0);
    }
}
