package org.lde.controller;

import org.lde.model.Cliente;
import org.lde.model.Proveedor;
import org.lde.service.ProveedorService;

import java.util.Scanner;

public class ProveedorController implements CRUD<Proveedor>{
    private ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @Override
    public void create(Proveedor proveedor) {
        proveedorService.save(proveedor);
    }

    @Override
    public void findOne(String cuit) {
        proveedorService.findOne(cuit);
    }

    @Override
    public void findAll() {
        proveedorService.findAll();
    }

    @Override
    public void findAllOff() {
        proveedorService.findAllOff();
    }

    @Override
    public void upDate(Proveedor proveedor) {
        proveedorService.upDate(proveedor);
    }

    @Override
    public void delete(String cuit) {
        proveedorService.delete(cuit);
    }
}
