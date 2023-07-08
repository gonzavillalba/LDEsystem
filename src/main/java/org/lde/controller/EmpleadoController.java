package org.lde.controller;

import org.lde.model.Empleado;
import org.lde.service.EmpleadoService;

public class EmpleadoController implements CRUD<Empleado> {
    EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @Override
    public void create(Empleado empleado) {
        empleadoService.save(empleado);

    }

    @Override
    public void findOne(String id) {
        empleadoService.findOne(id);

    }

    @Override
    public void findAll() {
        empleadoService.findAll();

    }

    @Override
    public void findAllOff() {
        empleadoService.findAllOff();

    }

    @Override
    public void upDate(Empleado empleado) {
        empleadoService.upDate(empleado);

    }

    @Override
    public void delete(String id) {
        empleadoService.delete(id);

    }
}
