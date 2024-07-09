package ru.my.Mocito.employeeService;


import org.junit.jupiter.api.Test;
import ru.my.Mocito.Employee;
import ru.my.Mocito.exceptions.EmployeeAlreadyAddedException;
import ru.my.Mocito.exceptions.EmployeeNotFoundException;
import ru.my.Mocito.exceptions.EmployeeStorageIsFullException;


import static org.junit.jupiter.api.Assertions.*;

class EmployeeImplTest {

    private final Iemployee employeeImpl = new EmployeeImpl();

    @Test
    public void corectAddEmployee() {
      //  Employee expectedEmployee = new Employee("Петя", 1, 100);
        Employee actual = employeeImpl.addEmployee("Петя", 1, 100);
        Employee expected = employeeImpl.findThis("Петя");
        assertEquals(expected, actual);
    }

    @Test
    public void correctEjectionEmployeeAlreadyAddedException() {
        Employee employee = new Employee("Петя", 1, 100);
        employeeImpl.addEmployee("Петя", 1, 100);
        assertThrows(
                EmployeeAlreadyAddedException.class,
                () -> employeeImpl.addEmployee("Петя", 1, 100));
    }

    @Test
    public void correctEjectionEmployeeStorageIsFullException() {
        int maxEmployee = 13;
        for (int i = 0; i < maxEmployee; i++) {
            employeeImpl.addEmployee("petya" + i, 1, 100);
        }
        assertThrows(
                EmployeeStorageIsFullException.class,
                () -> employeeImpl.addEmployee("petya", 1, 100)
        );

    }

    @Test
    void correctRemoveEmployee() {
        String fullName = "Петя";
        employeeImpl.addEmployee("Петя", 1, 100);
        Employee expected = null;
        Employee actual = employeeImpl.removeEmployee(fullName);
        assertEquals(expected, actual);
    }

    @Test
    void correctEjectionEmployeeNotFoundExceptionRemoveEmployee() {
        assertThrows(
                EmployeeNotFoundException.class,
                () -> employeeImpl.removeEmployee("Петка"));

    }

    @Test
    void correctEjectionEmployeeNotFoundExceptionFindThis() {
        assertThrows(
                EmployeeNotFoundException.class,
                () -> employeeImpl.findThis("Петька"));
    }



    @Test
    void correctFindThis() {
        employeeImpl.addEmployee("Петя", 1, 100);
        String actual = employeeImpl.findThis("Петя") + "";
        Employee employee = new Employee(("Петя"), 1, 100);
        String expected = employee.toString() + "";
        assertEquals(actual,expected);

    }
}