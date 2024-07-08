package ru.my.Mocito.departmentService;
import org.springframework.stereotype.Service;
import ru.my.Mocito.Employee;
import ru.my.Mocito.employeeService.Iemployee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentImpl implements Idepartment {
    private final Iemployee iemployee;

    public DepartmentImpl(Iemployee iemployee) {
        this.iemployee = iemployee;
    }

    @Override
    public Map<Integer, List<Employee>> depaertments() {
        return iemployee.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public ArrayList<Employee> employees(int id) {
        return iemployee.findAll().stream().filter(employee -> employee.getDepartment() == id)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public int allSalaryDepartment(int id) {
        return iemployee.findAll().stream()
                .filter(employee -> employee.getDepartment() == id).mapToInt(Employee::getSalary).
                sum();

    }

    @Override
    public int maxSalaryDepartment(int id) {
        return iemployee.findAll().stream()
                .filter(employee -> employee.getDepartment() == id)
                .max(Comparator.comparing(Employee::getSalary)).get().getSalary();
    }

    @Override
    public int minSalaryDepartment(int id) {
        return iemployee.findAll().stream()
                .filter(employee -> employee.getDepartment() == id)
                .min(Comparator.comparing(Employee::getSalary)).get().getSalary();
    }



}

