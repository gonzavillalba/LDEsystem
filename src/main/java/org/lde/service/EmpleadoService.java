package org.lde.service;

import org.lde.model.Empleado;
import org.lde.repository.EmpleadoRepository;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoService implements CRUD<Empleado> {
    EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public void save(Empleado empleado) {

        int contador = 0;

        for (Empleado er : findAll()) {
            if (er.getCUIT().equals(empleado.getCUIT())) {
                contador++;
            }
        }

        if (contador == 0) {
            empleadoRepository.save(empleado);
            System.out.println("VVVVVVVVVV El empleado ha sido creado con exito VVVVVVVVVVVV");
        }else{
            System.out.println("XXXXXXXXXXXXXXXX El empleado ya existe XXXXXXXXXXXXXXXXXXX");
        }
    }

    @Override
    public void upDate(Empleado empleado) {
        int cont = 0;
        for(Empleado er : findAll()){
            if(er.getCUIT().equals(empleado.getCUIT())){
                cont++;
            }
        }
        if(cont == 0){
            System.out.println("XXXXXXXXXXXXXXXXX El empleado ingresado no existe XXXXXXXXXXXXXXXXX");
        }else{

            empleadoRepository.upDate(empleado);
        }

    }

    @Override
    public Empleado findOne(String cuit) {
        Empleado empleado = null;
        int cont = 0;
        for(Empleado er : findAll()){
            if(er.getCUIT().equals(cuit)){
                cont++;
                empleado = er;
            }
        }
        if (cont == 0) {
            System.out.println("XXXXXXXXXXXXX El empleado buscado no existe XXXXXXXXXXX");
        }else{
            System.out.println("El cliente buscado es: " + empleadoRepository.findOne(cuit));
        }
        return empleado;
    }

    @Override
    public List<Empleado> findAll() {
        List<Empleado>empleadoList = new ArrayList<>();
        for(Empleado er : empleadoRepository.findAll()){
            System.out.println(er.toString());
        }

        return empleadoList;
    }

    @Override
    public List<Empleado> findAllOff() {
        List<Empleado>empleadoList = new ArrayList<>();
        for(Empleado er : empleadoRepository.findAllOff()){
            System.out.println(er.toString());
        }

        return empleadoList;
    }

    @Override
    public void delete(String cuit) {
        int cont = 0;
        for (Empleado er : findAll()){
            if (er.getCUIT().equals(cuit)) {
                cont++;
            }
        }
        if (cont == 0){
            System.out.println("XXXXXXXXXXXXXXXXXXX El empleado ingresado no existe XXXXXXXXXXXXXXXXXX");
        }else {
            empleadoRepository.delete(cuit);
            System.out.println("VVVVVVVVVVVVVVVVVV El empleado ha sido eliminado con exito VVVVVVVVVVVVVVVVVVV");
        }

    }
}
