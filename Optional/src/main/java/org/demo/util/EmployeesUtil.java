package org.demo.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeesUtil {

    public static List<Employee> getEmployeeList() {
        return Arrays.asList(
                new Employee(
                        1, "Name 1", "HR Department", BigDecimal.valueOf(100.00), 30),
                new Employee(
                        2, "Name 2", "HR Department", BigDecimal.valueOf(300.00), 26),
                new Employee(
                        3, "Name 3", "IT Department", BigDecimal.valueOf(600.00), 45),
                new Employee(
                        4, "Name 4", "HR Department", BigDecimal.valueOf(200.00), 55),
                new Employee(
                        5, "Name 5", "IT Department", BigDecimal.valueOf(400.00), 60)
        );
    }

}
