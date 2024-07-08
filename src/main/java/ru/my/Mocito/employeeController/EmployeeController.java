package ru.my.Mocito.employeeController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.my.Mocito.Employee;
import ru.my.Mocito.employeeService.EmployeeImpl;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeImpl employeeImpl;

    public EmployeeController(EmployeeImpl employeeImpl) {
        this.employeeImpl = employeeImpl;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("fullName") String fullName,
                              @RequestParam("department") int department, @RequestParam("salary") int salary) {
        return employeeImpl.addEmployee(fullName, department, salary);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("fullName") String fullName) {
        return employeeImpl.removeEmployee(fullName);
    }

    @GetMapping("/findThis")
    public Employee findThis(@RequestParam("fullName") String fullName) {
        return employeeImpl.findThis(fullName);
    }
}
