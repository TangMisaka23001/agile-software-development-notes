package com.agile.affiliation;

import com.agile.pay.PayCheck;
import com.agile.servicecharge.ServiceCharge;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.Map;

/**
 * affiliation.UnionAffiliation
 *
 * @author tangbin
 */
public class UnionAffiliation extends Affiliation {

    private final Map<LocalDateTime, ServiceCharge> serviceCharge = new HashMap<>();
    private final int memberId;
    private final double itsDues;

    public void addServiceCharge(LocalDateTime date, double charge) {
        this.serviceCharge.put(date, new ServiceCharge(date, charge));
    }

    public UnionAffiliation(int memberId, double itsDues) {
        this.memberId = memberId;
        this.itsDues = itsDues;
    }

    @Override
    public ServiceCharge getServiceCharge(LocalDateTime date) {
        return serviceCharge.get(date);
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

    private boolean isInPayPeriod(LocalDateTime theDate, PayCheck pc) {
        LocalDateTime payPeriodEndDate = pc.getPayPeriodEndDate();
        LocalDateTime payPeriodStartDate = pc.getPayPeriodStartDate();
        return theDate.equals(payPeriodStartDate)
                || theDate.equals(payPeriodEndDate)
                || (theDate.isAfter(payPeriodStartDate) && theDate.isBefore(payPeriodEndDate));
    }

    @Override
    public double calculateDeductions(PayCheck pc) {
        int fridays = numberOfFridaysInPayPeriod(pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate());
        double sumCharge = serviceCharge.entrySet().stream()
                .filter(e -> isInPayPeriod(e.getKey(), pc))
                .mapToDouble(e -> e.getValue().getAmount())
                .sum();
        return itsDues * fridays + sumCharge;
    }
}
