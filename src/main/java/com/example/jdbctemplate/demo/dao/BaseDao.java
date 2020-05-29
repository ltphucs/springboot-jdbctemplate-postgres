package com.example.jdbctemplate.demo.dao;

import java.util.List;

public interface BaseDao<T> {
    public List<T> getAll();

    public T findById(long id);

    public void add(T object);

    public void update(T object);

    public void deleteById(long id);
}
