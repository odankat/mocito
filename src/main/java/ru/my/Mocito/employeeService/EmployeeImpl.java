package ru.my.Mocito.employeeService;
import org.springframework.stereotype.Service;
import ru.my.Mocito.Employee;
import ru.my.Mocito.exceptions.EmployeeAlreadyAddedException;
import ru.my.Mocito.exceptions.EmployeeNotFoundException;
import ru.my.Mocito.exceptions.EmployeeStorageIsFullException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeImpl implements Iemployee {
    private final Map<String, Employee> employees = new HashMap<>();

    final int maxEmployee = 13;

    @Override
    public String addEmployee(String fullName, int department, int salary) {
        Employee employee = new Employee(fullName, department, salary);
        if (employees.size() >= maxEmployee) {
            throw new EmployeeStorageIsFullException("свободных мест нет");
        } else if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("такой сотрудник есть");
        }
        employees.put(fullName, employee);
        return employee.toString();
    }

    @Override
    public String removeEmployee(String fullName) {
        if (!employees.containsKey(fullName)) {
            throw new EmployeeNotFoundException("сотрудника нету");
        } else {
            employees.remove(fullName);
            return fullName + " сотрудник удален";
        }
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public Employee findThis(String fullName) {
        if (!employees.containsKey(fullName)) {
            throw new EmployeeNotFoundException("сотрудника нет");
        }
        return employees.get(fullName);
    }
}
