package com.example.jdbctemplate.demo.rest;

import com.example.jdbctemplate.demo.model.Employee;
import com.example.jdbctemplate.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> employees(){
        return employeeService.getAll();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> findById(@PathVariable long id){
        return  employeeService.findById(id);
    }

    @PostMapping("/employees")
    public Employee add(@RequestBody Employee employee){
        employeeService.add(employee);
        return employee;
    }

    @PatchMapping("/employees")
    public Employee edit(@RequestBody Employee employee){
        employeeService.edit(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public long edit(@PathVariable long id){
        employeeService.delete(id);
        return id;
    }
}
