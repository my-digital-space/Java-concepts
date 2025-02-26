package org.demo.shallow_vs_deep_copy;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Employee {
    Person person;
    String employeeId;

    Employee(Person person, String employeeId) {
        this.person = person;
        this.employeeId = employeeId;
    }
}
