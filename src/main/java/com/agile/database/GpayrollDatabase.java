package com.agile.database;

import com.agile.employee.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PayrollDatabase
 *
 * @author tangbin
 */
public class GpayrollDatabase {

    private static final Map<Integer, Employee> itsEmployees = new HashMap<>();
    private static final Map<Integer, Employee> itsMembers = new HashMap<>();

    public static Employee getEmployee(int empId) {
        return itsEmployees.get(empId);
    }

    public static void addEmployee(int empId, Employee employee) {
        itsEmployees.put(empId, employee);
    }

    public static void deleteEmployee(int empId) {
        itsEmployees.remove(empId);
    }

    public static void clear() {
        itsEmployees.clear();
    }

    public static Employee getUnionMember(int itsMemberId) {
        return itsMembers.get(itsMemberId);
    }

    public static void addUnionMember(int memberId, Employee e) {
        itsMembers.put(memberId, e);
    }

    public static void removeUnionMember(int memberId) {
        itsMembers.remove(memberId);
    }

    public static List<Integer> getAllEmployeeIds() {
        return new ArrayList<>(itsEmployees.keySet());
    }
}
