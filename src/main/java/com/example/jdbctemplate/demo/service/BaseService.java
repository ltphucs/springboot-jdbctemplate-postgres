package com.example.jdbctemplate.demo.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    List<T> getAll();
    void add(T object);
    void edit(T object);
    Optional<T> findById(long id);
    void delete(long id);
}
