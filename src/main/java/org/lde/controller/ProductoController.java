package org.lde.controller;

import org.lde.model.CategoriaProducto;
import org.lde.model.Producto;
import org.lde.model.Proveedor;
import org.lde.repository.ProveedorRepository;
import org.lde.service.ProductoService;

import java.util.Scanner;

public class ProductoController implements CRUD<Producto>{
    private ProductoService productoService;
    ProveedorRepository proveedorRepository = new ProveedorRepository();
    Scanner leer = new Scanner(System.in);

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Override
    public void create(Producto producto) {
        productoService.save(producto);
    }

    @Override
    public void findOne(String id) {

        productoService.findOne(id);
    }

    @Override
    public void findAll() {
        productoService.findAll();

    }

    @Override
    public void findAllOff() {
        productoService.findAllOff();
    }

    @Override
    public void upDate(Producto producto) {
        productoService.upDate(producto);
    }

    @Override
    public void delete(String id) {

        productoService.delete(id);
    }
}
