package org.demo.optional;

import org.demo.util.Employee;
import java.math.BigDecimal;

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
