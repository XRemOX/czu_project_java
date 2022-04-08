package com.czu.project.service;

import java.util.List;

public interface ServiceInt<T> {
    List<T> findAll();

    void save(T t);

    T findById(int id);

    void deleteById(int id);
}
