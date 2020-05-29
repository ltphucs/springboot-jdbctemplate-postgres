package com.example.jdbctemplate.demo.dao;

import com.example.jdbctemplate.demo.model.Employee;
import com.example.jdbctemplate.demo.model.mapper.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class EmployeeDao implements BaseDao<Employee> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAll() {

        String query = "SELECT * from employees";
        RowMapper<Employee> rowMapper = new EmployeeRowMapper();
        List<Employee> list = jdbcTemplate.query(query, rowMapper);

        return list;
    }

    @Override
    public Employee findById(long id) {
        String query = "SELECT * FROM employees WHERE id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(query, rowMapper, id);
        return employee;
    }

    @Override
    public void add(Employee object) {
        String query = "INSERT INTO employees(firstname, lastname, email, phone, jobtitle) VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.update(query,  object.getFirstName(), object.getLastName(), object.getEmail(), object.getPhone(), object.getJobTitle());

    }

    @Override
    public void update(Employee object) {
        String query = "UPDATE employees SET firstname=?, lastname=?, email=?, phone=?, jobtitle=? WHERE id=?";
        jdbcTemplate.update(query, object.getFirstName(), object.getLastName(), object.getEmail(), object.getPhone(), object.getJobTitle(), object.getId());


    }

    @Override
    public void deleteById(long id) {
        String query = "DELETE FROM employees WHERE id=?";
        jdbcTemplate.update(query, id);

    }
}
