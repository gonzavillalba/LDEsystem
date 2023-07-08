package org.lde.service;

import org.lde.model.Cliente;
import org.lde.model.Producto;
import org.lde.model.Proveedor;
import org.lde.repository.ProductoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductoService implements CRUD<Producto> {
    ProductoRepository productoRepository = new ProductoRepository();

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void save(Producto producto) {
        int contador = 0;

        for (Producto pr : findAll()) {
            if (pr.getIdPreoducto().equals(producto.getIdPreoducto())) {
                contador++;
            }
        }

        if (contador == 0) {
            productoRepository.save(producto);
            System.out.println("VVVVVVVVVV El producto ha sido creado con exito VVVVVVVVVVVV");
        }else {
            System.out.println("XXXXXXXXXXXXXXXX El producto ya existe XXXXXXXXXXXXXXXXXXX");
        }
    }

    @Override
    public void upDate(Producto producto) {
        int cont = 0;

        for(Producto pr : findAll()){
            if(pr.getIdPreoducto().equals(producto.getIdPreoducto())){
                cont++;
            }
        }
        if(cont == 0){
            System.out.println("XXXXXXXXXXXXXXXXX El Producto ingresado no existe XXXXXXXXXXXXXXXXX");
        }else{

            productoRepository.upDate(producto);
        }
    }

    @Override
    public Producto findOne(String cuit) {
        Producto producto = null;
        int cont = 0;
        for(Producto pr : findAll()){
            if(pr.getIdPreoducto().equals(cuit) || pr.getDescripcion().equals(cuit)){
                cont++;
                producto = pr;
            }
        }
        if (cont == 0) {
            System.out.println("XXXXXXXXXXXXX El producto buscado no existe XXXXXXXXXXX");
        }else{
            System.out.println("El producto buscado es: " + productoRepository.findOne(cuit));
        }
        return producto;
    }

    @Override
    public List<Producto> findAll() {
        List<Producto>productoList = new ArrayList<>();
        for(Producto pr : productoRepository.findAll()){
            System.out.println(pr.toString());
        }

        return productoList;
    }

    @Override
    public List<Producto> findAllOff() {
        List<Producto>productoList = new ArrayList<>();
        for(Producto pr : productoRepository.findAllOff()){
            System.out.println(pr.toString());
        }

        return productoList;
    }

    @Override
    public void delete(String cuit) {
        int cont = 0;
        for (Producto pr : findAll()){
            if (pr.getIdPreoducto().equals(cuit)){
                cont++;
            }
        }
        if (cont == 0){
            System.out.println("XXXXXXXXXXXXXXXXXXX El producto ingresado no existe XXXXXXXXXXXXXXXXXX");
        }else {
            productoRepository.delete(cuit);
            System.out.println("VVVVVVVVVVVVVVVVVV El producto ha sido eliminado con exito VVVVVVVVVVVVVVVVVVV");
        }
    }
}
