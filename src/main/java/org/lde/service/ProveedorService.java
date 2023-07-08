package org.lde.service;

import org.lde.model.Cliente;
import org.lde.model.Proveedor;
import org.lde.repository.ClienteRepository;
import org.lde.repository.ProveedorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProveedorService implements CRUD<Proveedor>{
    ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public void save(Proveedor proveedor) {
        int contador = 0;

        for (Proveedor pr : findAll()) {
            if (pr.getCuit().equals(proveedor.getCuit())) {
                contador++;
            }
        }

        if (contador == 0) {
            proveedorRepository.save(proveedor);
            System.out.println("VVVVVVVVVV El proveedor ha sido creado con exito VVVVVVVVVVVV");
        }else{
            System.out.println("XXXXXXXXXXXXXXXX El proveedor ya existe XXXXXXXXXXXXXXXXXXX");
        }
    }

    @Override
    public void upDate(Proveedor proveedor) {
        int contador = 0;
        for(Proveedor pr : findAll()){
            if(pr.getCuit().equals(proveedorRepository.findOne(proveedor.getCuit()))){
                contador++;
            }
        }
        if(contador == 0){
            System.out.println("XXXXXXXXXXXXXXXXX El proveedor ingresado no existe XXXXXXXXXXXXXXXXX");
        }else {
            proveedorRepository.upDate(proveedor);
        }
    }

    @Override
    public Proveedor findOne(String cuit) {
        Proveedor proveedor = null;
        int cont = 0;
        for(Proveedor pr : findAll()){
            if(pr.getCuit().equals(cuit)){
                proveedor = pr;
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("XXXXXXXXXXXXX El cliente buscado no existe XXXXXXXXXXX");
        }else {
            System.out.println("El cliente buscado es: " + proveedorRepository.findOne(cuit));
        }
        return proveedor;
    }




    @Override
    public List<Proveedor> findAll() {
        List<Proveedor>proveedorList = new ArrayList<>();
        for(Proveedor pr : proveedorRepository.findAll()){
            System.out.println(pr.toString());
        }

        return proveedorList;
    }

    @Override
    public List<Proveedor> findAllOff() {
        List<Proveedor>proveedorList = new ArrayList<>();
        for(Proveedor pr : proveedorRepository.findAllOff()){
            System.out.println(pr.toString());
        }

        return proveedorList;
    }

    @Override
    public void delete(String cuit) {
        int cont = 0;
        for (Proveedor pr : findAll()){
            if (pr.getCuit().equals(cuit));
            cont++;
        }
        if (cont == 0){
            System.out.println("XXXXXXXXXXXXXXXXXXX El proveedor ingresado no existe XXXXXXXXXXXXXXXXXX");
        }else {
            proveedorRepository.delete(cuit);
            System.out.println("VVVVVVVVVVVVVVVVVV El proveedor ha sido eliminado con exito VVVVVVVVVVVVVVVVVVV");
        }

    }
}
