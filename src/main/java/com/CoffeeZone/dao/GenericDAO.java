package com.CoffeeZone.dao;

import java.util.ArrayList;

public interface GenericDAO<T> {
    ArrayList<T> findAll();
    T findById(Integer id);
    T save(T t);
    T update(T t);
    void deleteById(Integer id);
}
