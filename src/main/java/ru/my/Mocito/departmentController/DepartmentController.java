package ru.my.Mocito.departmentController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.my.Mocito.Employee;
import ru.my.Mocito.departmentService.DepartmentImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentImpl departmentimpl;

    public DepartmentController(DepartmentImpl departmentimpl) {
        this.departmentimpl = departmentimpl;
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> departmentEmployee() {
        return departmentimpl.depaertments();
    }

    @GetMapping("/{id}/employees")
    public List<Employee> employeesDepartment(@PathVariable int id) {
        return departmentimpl.employees(id);
    }

    @GetMapping("/{id}/salary/sum")
    public int allSalaryDepartment(@PathVariable int id) {
        return departmentimpl.allSalaryDepartment(id);
    }

    @GetMapping("/{id}/salary/max")
    public int maxSalaryDepartment(@PathVariable int id) {
        return departmentimpl.maxSalaryDepartment(id);
    }

    @GetMapping("/{id}/salary/min")
    public int minSalaryDepartment(@PathVariable int id) {
        return departmentimpl.minSalaryDepartment(id);
    }


}
