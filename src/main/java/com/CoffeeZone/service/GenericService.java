package com.CoffeeZone.service;

import java.util.ArrayList;

public interface GenericService<T> {
    ArrayList<T> findAll();
    T save(T t);
    T update(T t);
    void deleteById(Integer id);
    T findById(Integer id);
}
