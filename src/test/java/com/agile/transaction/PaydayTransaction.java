package com.agile.transaction;

import com.agile.classification.PaymentClassification;
import com.agile.database.GpayrollDatabase;
import com.agile.employee.Employee;
import com.agile.pay.PayCheck;
import com.agile.schedule.PaymentSchedule;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * PaydayTransaction
 *
 * @author tangbin
 */
public class PaydayTransaction extends Transaction {

    private final LocalDateTime itsPayDate;
    private final Map<Integer, PayCheck> itsPaychecks = new HashMap<>();

    public PaydayTransaction(LocalDateTime itsPayDate) {
        this.itsPayDate = itsPayDate;
    }

    @Override
    public void execute() {
        List<Integer> empIds = GpayrollDatabase.getAllEmployeeIds();
        for (Integer empId : empIds) {
            Employee e = GpayrollDatabase.getEmployee(empId);
            if (Objects.nonNull(e)) {
                if (e.isPayDate(itsPayDate)) {
                    PayCheck pc = new PayCheck(itsPayDate);
                    itsPaychecks.put(empId, pc);
                    e.payday(pc);
                }
            }
        }
    }

    @Override
    public PaymentClassification getClassification() {
        return null;
    }

    @Override
    public PaymentSchedule getSchedule() {
        return null;
    }

    public PayCheck getPayCheck(int empId) {
        return itsPaychecks.get(empId);
    }
}
