package org.lde.repository;

import java.util.List;

public interface CRUD<T>{
    void upLoad();
    void save(T t);
    void upDate(T t);
    List<T> findAll();
    List<T> findAllOff();
    T findOne(String cuit);
    void delete(String cuit);



}
