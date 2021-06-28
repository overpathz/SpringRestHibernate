package com.overpathz.spring.rest.controller;

import com.overpathz.spring.rest.entity.Employee;
import com.overpathz.spring.rest.exception.EmployeeIncorrectData;
import com.overpathz.spring.rest.exception.NoSuchEmployee;
import com.overpathz.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> showAllEmployee() {
        List<Employee> allEmployee = employeeService.getAllEmployees();
        return allEmployee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployee(@PathVariable("id") int id) {
        Employee deletedEmployee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);
        return deletedEmployee;
    }

    @GetMapping("/employees/{id}")
    public Employee showAllEmployee(@PathVariable("id") int id) {
        Employee employee = employeeService.getEmployee(id);

        if (employee != null) {
            return employee;
        } else {
            throw new NoSuchEmployee("There is no employee with ID = " + id + " in database");
        }
    }
}
