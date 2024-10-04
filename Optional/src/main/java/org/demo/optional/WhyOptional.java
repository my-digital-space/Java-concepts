package org.demo.optional;

import org.demo.util.Employee;

import java.math.BigDecimal;
import java.util.Optional;

public class WhyOptional {

    public static void main(String[] args) {
        int id = 1;
//        Employee employee = findEmployeeById(id);
//        if (employee != null) {
//            System.out.println("Employee Name: " + employee.getEmpName());
//        } else {
//            System.out.println("Employee not found with id: " + id);
//        }

//        Optional<Employee> optionalEmployee = findEmployeeByIdOptional(1);
//        if (optionalEmployee.isPresent()){
//            System.out.println(optionalEmployee.get());
//        } else {
//            System.out.println("Employee not found with id: " + id);
//        }

//        Optional<Employee> optionalEmployee = findEmployeeByIdOptional(1);
//        Employee defaultEmployee = new Employee(
//                0, "Default name", "Default Department",
//                BigDecimal.valueOf(100.00), 30);
//        System.out.println(optionalEmployee.orElse(defaultEmployee));

        Optional<Employee> optionalEmployee = findEmployeeByIdOptional(1);
        System.out.println(optionalEmployee.map(Employee::getEmpName).orElse("My Default Name"));


    }

    public static Optional<Employee> findEmployeeByIdOptional(int id) {
        Employee employee = new Employee(
                1, "Name 1", "HR Department",
                BigDecimal.valueOf(100.00), 30);
        return Optional.ofNullable(employee);
    }

    public static Employee findEmployeeById(int id) {
        Employee employee = new Employee(
                1, "Name 1", "HR Department",
                BigDecimal.valueOf(100.00), 30);
        return null;
    }

}
