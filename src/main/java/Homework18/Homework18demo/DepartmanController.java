package Homework18.Homework18demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping ("/departments")
public class DepartmanController {

    private final DepartmanService departmanService;

    public DepartmanController(DepartmanService departmanService) {
        this.departmanService = departmanService;
    }

    @GetMapping(path = "/max-selary")
    public Employee max(@RequestParam int departmentId) {
        return departmanService.employeeMaxSalaryDep(departmentId);
    }

    @GetMapping(path = "/min-selary")
    public Employee min(@RequestParam int departmentId) {
        return departmanService.employeeMinSalaryDep(departmentId);

    }


    @GetMapping(path = "/all")
    public List<Employee> all(@RequestParam int departmentId) {
        return departmanService.employeeAllDep(departmentId);
    }

    @GetMapping
    public Map<Integer, List<Employee>> all() {
        return departmanService.groupEmployeeDep();
    }
}
