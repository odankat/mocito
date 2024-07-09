package ru.my.Mocito.employeeController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.my.Mocito.Employee;
import ru.my.Mocito.employeeService.Iemployee;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final Iemployee employeeImpl;

    public EmployeeController(Iemployee employeeImpl) {
        this.employeeImpl = employeeImpl;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("fullName") String fullName,
                              @RequestParam("department") int department, @RequestParam("salary") int salary) {
        return employeeImpl.addEmployee(fullName, department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("fullName") String fullName) {
        return employeeImpl.removeEmployee(fullName);
    }

    @GetMapping("/findThis")
    public Employee findThis(@RequestParam("fullName") String fullName) {
        return employeeImpl.findThis(fullName);
    }
}
