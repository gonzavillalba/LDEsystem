package org.lde.service;

import org.lde.model.Sucursal;
import org.lde.model.TipoTransportista;
import org.lde.model.Transportista;
import org.lde.repository.TipoTransportistaRepository;

import java.util.ArrayList;
import java.util.List;

public class TipoTransportistaService implements CRUD<TipoTransportista> {
    TipoTransportistaRepository tipoTransportistaRepository;

    public TipoTransportistaService(TipoTransportistaRepository tipoTransportistaRepository) {
        this.tipoTransportistaRepository = tipoTransportistaRepository;
    }

    @Override
    public void save(TipoTransportista tipoTransportista) {
        int contador = 0;

        for (TipoTransportista ttr : findAll()) {
            if (ttr.getDescripcion().equals(tipoTransportista.getDescripcion())){
                contador++;
            }
        }

        if (contador == 0) {
            tipoTransportistaRepository.save(tipoTransportista);
            System.out.println("VVVVVVVVVV La sucursal ha sido creado con exito VVVVVVVVVVVV");
        }else {
            System.out.println("XXXXXXXXXXXXXXXX La sucursal ya existe XXXXXXXXXXXXXXXXXXX");
        }
    }

    @Override
    public void upDate(TipoTransportista tipoTransportista) {
        if (findOne(tipoTransportista.getDescripcion())!= null){
                tipoTransportistaRepository.upDate(tipoTransportista);
        }else {
            System.out.println("XXXXXXXXXXXXXXXXX La sucursal ingresada no existe XXXXXXXXXXXXXXXXX");
        }
    }

    @Override
    public TipoTransportista findOne(String cuit) {
        TipoTransportista ttra = null;
        int cont = 0;
        for(TipoTransportista ttr : findAll()){
            if(ttr.getDescripcion().equals(cuit)){
                ttra = ttr;
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("XXXXXXXXXXXXX El transportista buscado no existe XXXXXXXXXXX");
        }else{
            System.out.println("El transportista buscado es: " + tipoTransportistaRepository.findOne(cuit));
        }
        return ttra;
    }

    @Override
    public List<TipoTransportista> findAll() {
        List<TipoTransportista>tipoTransportistaList = new ArrayList<>();
        for(TipoTransportista ttr : tipoTransportistaRepository.findAll()){
            System.out.println(ttr.toString());
        }

        return tipoTransportistaList;
    }

    @Override
    public List<TipoTransportista> findAllOff() {
        List<TipoTransportista>tipoTransportistaList = new ArrayList<>();
        for(TipoTransportista ttr : tipoTransportistaRepository.findAllOff()){
            System.out.println(ttr.toString());
        }

        return tipoTransportistaList;
    }

    @Override
    public void delete(String cuit) {
        if (tipoTransportistaRepository.findOne(cuit) != null){
            tipoTransportistaRepository.delete(cuit);
            System.out.println("VVVVVVVVVVVVVVVVVV El tipo de transporte ha sido eliminado con exito VVVVVVVVVVVVVVVVVVV");

        }else {
            System.out.println("XXXXXXXXXXXXXXXXXXX El tipo de transporte ingresado no existe XXXXXXXXXXXXXXXXXX");
        }
    }
}
