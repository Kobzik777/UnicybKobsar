package com.company.dao;

import java.util.List;

/**
 * Created by Serhii_Kobzar on 10/4/2016.
 */
public interface GenericDao<T> {
    T find(int id);
    List<T> findAll();
    void update(T entity,int id);
    void delete(int id);
    void insert(T entity);
}
