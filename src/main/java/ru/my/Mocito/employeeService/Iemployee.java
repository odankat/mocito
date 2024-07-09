package ru.my.Mocito.employeeService;

import ru.my.Mocito.Employee;

import java.util.Collection;

public interface Iemployee {
    Employee addEmployee(String fullname, int department, int salary);

    Employee removeEmployee(String fullname);

    Collection<Employee> findAll();


    Employee findThis(String fullName);
}
