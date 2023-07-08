package org.lde.service;

import org.lde.model.Cliente;
import org.lde.model.Sucursal;
import org.lde.model.TipoTransportista;
import org.lde.model.Transportista;
import org.lde.repository.TransportistaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransportistaService implements CRUD<Transportista> {
    TransportistaRepository transportistaRepository;

    public TransportistaService(TransportistaRepository transportistaRepository) {
        this.transportistaRepository = transportistaRepository;
    }

    @Override
    public void save(Transportista transportista) {
        int contador = 0;

        for (Transportista tr : findAll()) {
            if (tr.getCuit().equals(transportista.getCuit())) {
                contador++;
            }
        }

        if (contador == 0) {
            transportistaRepository.save(transportista);
            System.out.println("VVVVVVVVVV El transportista ha sido creado con exito VVVVVVVVVVVV");
        }else{
            System.out.println("XXXXXXXXXXXXXXXX El transportista ya existe XXXXXXXXXXXXXXXXXXX");
        }
    }

    @Override
    public void upDate(Transportista transportista) {
        int cont = 0;
        for(Transportista tr : findAll()){
            if(tr.getCuit().equals(transportista.getCuit())){
                cont++;
            }
        }
        if(cont == 0){
            System.out.println("XXXXXXXXXXXXXXXXX El transportista ingresado no existe XXXXXXXXXXXXXXXXX");
        }else{

            transportistaRepository.upDate(transportista);
        }


    }

    @Override
    public Transportista findOne(String cuit) {
        Transportista tra = null;
        int cont = 0;
        for(Transportista tr : findAll()){
            if(tr.getCuit().equals(cuit)){
                tra = tr;
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("XXXXXXXXXXXXX El transportista buscado no existe XXXXXXXXXXX");
        }else{
            System.out.println("El transportista buscado es: " + transportistaRepository.findOne(cuit));
        }
        return tra;
    }

    @Override
    public List<Transportista> findAll() {
        List<Transportista>transportistaList = new ArrayList<>();
        for(Transportista tr : transportistaRepository.findAll()){
            System.out.println(tr.toString());
        }

        return transportistaList;
    }

    @Override
    public List<Transportista> findAllOff() {
        List<Transportista>transportistaList = new ArrayList<>();
        for(Transportista tr : transportistaRepository.findAllOff()){
            System.out.println(tr.toString());
        }

        return transportistaList;
    }

    @Override
    public void delete(String cuit) {
        if (transportistaRepository.findOne(cuit) != null){
            transportistaRepository.delete(cuit);
            System.out.println("VVVVVVVVVVVVVVVVVV El transportista ha sido eliminado con exito VVVVVVVVVVVVVVVVVVV");

        }else {
            System.out.println("XXXXXXXXXXXXXXXXXXX El transportista ingresado no existe XXXXXXXXXXXXXXXXXX");
        }
    }
}
