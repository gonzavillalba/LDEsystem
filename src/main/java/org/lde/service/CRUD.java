package org.lde.service;

import org.lde.model.Sucursal;

import java.util.List;

public interface CRUD <T>{
    void save(T t);

    void upDate(T t);

    T findOne(String cuit);
    List<T>findAll();
    List<T>findAllOff();
    void delete(String cuit);

}
