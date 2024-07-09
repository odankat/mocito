package ru.my.Mocito.departmentService;

import org.assertj.core.api.Assertions;

// import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.my.Mocito.Employee;
import ru.my.Mocito.employeeService.EmployeeImpl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class DepartmentImplTest {
    private final List<Employee> employeeList = new ArrayList<>() {{
        add(new Employee("Вася1", 1, 100));
        add(new Employee("Вася2", 1, 200));
        add(new Employee("Вася3", 1, 300));
        add(new Employee("Вася4", 2, 150));
        add(new Employee("Вася6", 2, 100));
        add(new Employee("Вася7", 3, 170));
        add(new Employee("Вася9", 3, 240));
    }};
    private final Map<String, Employee> employees = new HashMap<>();

    @Mock
    private EmployeeImpl employeeImpl;

    @BeforeEach
    public void initMap() {
        for (Employee employee : employeeList) {
            employees.put(employee.getFullName(), employee);
        }
    }

    @InjectMocks
    private DepartmentImpl departmentImpl;

    @Test
    void correctDepaertments() {
        Mockito.when(employeeImpl.findAll()).thenReturn(employees.values());
        int id = 1;
        List<Employee> expected = List.of(employeeList.get(0), employeeList.get(1), employeeList.get(2));
        List<Employee> actual = departmentImpl.employees(id);
        Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void correctGroupDepartment() {
        Map<Integer, List<Employee>> expected = new HashMap<>() {{
            put(1, List.of(employeeList.get(2), employeeList.get(1), employeeList.get(0)));
            put(2, List.of(employeeList.get(4), employeeList.get(3)));
            put(3, List.of(employeeList.get(5), employeeList.get(6)));
        }};
        Mockito.when(employeeImpl.findAll()).thenReturn(employees.values());
        Map<Integer, List<Employee>> actual = departmentImpl.depaertments();
        Assertions.assertThat(expected).isEqualTo(actual);
    }
    @Test
    void correctAllSalaryDepartment() {
        int id = 1;
        Mockito.when(employeeImpl.findAll()).thenReturn(employees.values());
        int expected = employeeList.get(0).getSalary() + employeeList.get(1).getSalary() +  employeeList.get(2).getSalary();
        int actual = departmentImpl.allSalaryDepartment(id);
        Assertions.assertThat(expected).isEqualTo(actual);

    }


    @Test
    void correctMaxSalaryDepartment() {
        int id = 1;
        Mockito.when(employeeImpl.findAll()).thenReturn(employees.values());
        int expected = employeeList.get(2).getSalary() ;
        int actual = departmentImpl.maxSalaryDepartment(id);
        Assertions.assertThat(expected).isEqualTo(actual);    }

    @Test
    void correctMinSalaryDepartment() {
        int id = 1;
        Mockito.when(employeeImpl.findAll()).thenReturn(employees.values());
        int expected = employeeList.get(0).getSalary() ;
        int actual = departmentImpl.minSalaryDepartment(id);
        Assertions.assertThat(expected).isEqualTo(actual);
    }
}