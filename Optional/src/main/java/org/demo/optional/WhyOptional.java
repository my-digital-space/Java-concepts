package org.demo.optional;

import org.demo.util.Employee;
import org.demo.util.EmployeesUtil;

import java.math.BigDecimal;
import java.util.List;

public class WhyOptional {

    public static void main(String[] args) {
        Employee employee = findEmployeeById(1);
        System.out.println("Employee Name: " + employee.getEmpName());
    }

    public static Employee findEmployeeById(int id) {
        Employee employee = new Employee(
                1, "Name 1", "HR Department",
                BigDecimal.valueOf(100.00), 30);
        return employee;
    }

}
