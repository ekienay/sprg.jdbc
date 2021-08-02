package com.def.dao;

import java.util.List;

public interface DAO<T> {

    void save(T t);
    void update(T t);
    void delete(Long id);
    T find(int id);

    List<T> findAll();
}
