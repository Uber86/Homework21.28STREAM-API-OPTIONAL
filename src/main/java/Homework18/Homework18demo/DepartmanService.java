package Homework18.Homework18demo;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmanService {

    private final EmployeeService employeeService;

    public DepartmanService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee employeeMaxSalaryDep(int deport) {
        return employeeService.getAll()
                .stream()
                .filter(employee -> deport == employee.getDeport())
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee employeeMinSalaryDep(int deport) {
        return employeeService.getAll()
                .stream()
                .filter(employee -> deport == employee.getDeport())
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> employeeAllDep(int deport) {
        return employeeService.getAll()
                .stream()
                .filter(employee -> deport == employee.getDeport())
                .toList();

    }

    public Map<Integer, List<Employee>> groupEmployeeDep() {
        return employeeService.getAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDeport));

    }



}
