package Homework18.Homework18demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private static final int maxEmployee = 10;

    private final List<Employee> employees = new ArrayList<>(maxEmployee);

    public void addEmployee(String firstName, String lastName) {

        if (employees.size()> maxEmployee){
            try {
                throw new EmployeeStorageIsFullException();
            } catch (EmployeeStorageIsFullException a) {
                throw new RuntimeException("Нет места в компании.");
            }
         }

        Employee emp = new Employee(firstName, lastName);
        if (employees.contains(emp)) {
            try {
                throw new EmployeeAlreadyAddedException();
            } catch (EmployeeAlreadyAddedException b) {
                throw new RuntimeException("Данный сотрудник уже работает в компании.");
            }
        }
        employees.add(emp);


    }

    public void removeEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                employees.remove(employee);
                return;
            }
        }
        try {
            throw new EmployeeNotFoundException();
        } catch (EmployeeNotFoundException c) {
            throw new RuntimeException("Сотрудник не найден");
        }
    }


    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {

                return employee;
            }
        }
        try {
            throw new EmployeeNotFoundException();
        } catch (EmployeeNotFoundException c) {
            throw new RuntimeException("Сотрудник не найден");
        }
    }

    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees);
    }
}
