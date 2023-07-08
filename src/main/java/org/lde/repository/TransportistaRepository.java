package org.lde.repository;

import lombok.Getter;
import lombok.Setter;
import org.lde.model.Cliente;
import org.lde.model.TipoTransportista;
import org.lde.model.Transportista;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public class TransportistaRepository implements CRUD<Transportista>{
    public List<Transportista>transportistas;

    public TransportistaRepository() {
        transportistas = new ArrayList<>();
        upLoad();
    }

    @Override
    public void upLoad() {
        TipoTransportista ttA = new TipoTransportista("Aereo");
        TipoTransportista ttM = new TipoTransportista("Maritimo");
        TipoTransportista ttT = new TipoTransportista("Terrestre");

        Transportista t1 = new Transportista("1","OCA","0800","oca@gmail",ttT);
        Transportista t2 = new Transportista("2","Correo Argentino","0400","coarg@gmail",ttT);
        Transportista t3 = new Transportista("3","Maritima Heinlein","0200","mh@gmail",ttM);
        Transportista t4 = new Transportista("4","Aguirio Maritima y Fluvial S.A.","0800","amf@gmail",ttM);
        Transportista t5 = new Transportista("5","Blue Star","0100","oca@gmail",ttA);
        Transportista t6 = new Transportista("6","Aerocargas Argentinas S.A","0300","aearg@gmail",ttA);

        transportistas.add(t1);
        transportistas.add(t2);
        transportistas.add(t3);
        transportistas.add(t4);
        transportistas.add(t5);
        transportistas.add(t6);
    }

    @Override
    public void save(Transportista transportista) {
        transportistas.add(transportista);
    }

    @Override
    public void upDate(Transportista transportista) {
        if (findOne(transportista.getCuit()) != null){
            findOne(transportista.getCuit()).setNombre(transportista.getNombre());
            findOne(transportista.getCuit()).setTelefono(transportista.getTelefono());
            findOne(transportista.getCuit()).setEmail(transportista.getEmail());
            findOne(transportista.getCuit()).setTipo(transportista.getTipo());
        }

    }

    @Override
    public List<Transportista> findAll() {
        List<Transportista>transportistasHabilitados = new ArrayList<>();
        for(Transportista tr : transportistas){
            if(tr.getEstado().equals(Transportista.Estado.Habilitado)){
                transportistasHabilitados.add(tr);
            }
        }
        return transportistasHabilitados;
    }

    @Override
    public List<Transportista> findAllOff() {
        List<Transportista>transportistasInhabilitados = new ArrayList<>();
        for(Transportista tr : transportistas){
            if(tr.getEstado().equals(Transportista.Estado.Invalido)){
                transportistasInhabilitados.add(tr);
            }
        }
        return transportistasInhabilitados;
    }

    @Override
    public Transportista findOne(String cuit) {
        Transportista transportista = null;
        for (Transportista tr : transportistas){
            if (tr.getCuit().equals(cuit)){
                transportista = tr;
            }
        }
        return transportista;
    }

    @Override
    public void delete(String cuit) {
            if(findOne(cuit) != null){
                findOne(cuit).setEstado(Transportista.Estado.Invalido);
            }


    }
}
