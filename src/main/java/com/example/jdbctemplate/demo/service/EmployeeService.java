package com.example.jdbctemplate.demo.service;

import com.example.jdbctemplate.demo.dao.EmployeeDao;
import com.example.jdbctemplate.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements BaseService<Employee> {
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public void add(Employee object) {
            employeeDao.add(object);
    }

    @Override
    public void edit(Employee object) {
        employeeDao.update(object);
    }

    @Override
    public Optional<Employee> findById(long id) {
        Employee employee= employeeDao.findById(id);
        if (employee!=null)
            return Optional.of(employee);
        else
            return Optional.empty();


    }

    @Override
    public void delete(long id) {
        employeeDao.deleteById(id);
    }
}
