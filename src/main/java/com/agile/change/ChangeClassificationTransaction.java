package com.agile.change;

import com.agile.classification.PaymentClassification;
import com.agile.employee.Employee;
import com.agile.schedule.PaymentSchedule;

/**
 * ChangeClassificationTransaction
 *
 * @author tangbin
 */
public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {

    public ChangeClassificationTransaction(int itsEmpId) {
        super(itsEmpId);
    }

    @Override
    public void change(Employee e) {
        e.setClassification(getClassification());
        e.setSchedule(getSchedule());
    }

    public abstract PaymentClassification getClassification();

    public abstract PaymentSchedule getSchedule();
}
