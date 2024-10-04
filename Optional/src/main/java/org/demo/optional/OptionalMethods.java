package org.demo.optional;

import org.demo.util.Employee;

import java.math.BigDecimal;
import java.util.Optional;

public class OptionalMethods {

    public static void main(String[] args) {
        Optional<Employee> optionalEmployee = findEmployeeByIdOptional(1);

        System.out.println(optionalEmployee.isPresent());
    }

    public static Optional<Employee> findEmployeeByIdOptional(int id) {
        Employee employee = new Employee(
                1, "Name 1", "HR Department",
                BigDecimal.valueOf(100.00), 30);
        return Optional.ofNullable(employee);
    }


}
