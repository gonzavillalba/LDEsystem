package org.lde.controller;

public interface CRUD <T>{
    void create(T t);
    void findOne(String id);
    void findAll();
    void findAllOff();
    void upDate(T t);
    void delete(String id);
}
