package org.lde.repository;

import lombok.Getter;
import lombok.Setter;
import org.lde.model.Sucursal;
import org.lde.model.TipoTransportista;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TipoTransportistaRepository implements CRUD<TipoTransportista> {
    private List<TipoTransportista> tiposTransportista;

    public TipoTransportistaRepository() {
        tiposTransportista = new ArrayList<>();
        upLoad();
    }

    @Override
    public void upLoad() {
        TipoTransportista ttAereo = new TipoTransportista("Aereo");
        TipoTransportista ttMaritimo = new TipoTransportista("Maritimo");
        TipoTransportista ttTerrestre = new TipoTransportista("Terrestre");

        tiposTransportista.add(ttAereo);
        tiposTransportista.add(ttMaritimo);
        tiposTransportista.add(ttTerrestre);
    }

    @Override
    public void save(TipoTransportista tipoTransportista) {
        tiposTransportista.add(tipoTransportista);
    }

    @Override
    public void upDate(TipoTransportista tipoTransportista) {
        if (findOne(tipoTransportista.getDescripcion()) != null) {
            findOne(tipoTransportista.getDescripcion()).setDescripcion(tipoTransportista.getDescripcion());
        }
    }

    @Override
    public List<TipoTransportista> findAll() {
        List<TipoTransportista>tipoTransportistasHabilitados = new ArrayList<>();
        for (TipoTransportista ttr : tiposTransportista){
            if(ttr.getEstado() == TipoTransportista.Estado.Habilitado){
                tipoTransportistasHabilitados.add(ttr);
            }
        }
        return tipoTransportistasHabilitados;
    }

    @Override
    public List<TipoTransportista> findAllOff() {
        List<TipoTransportista>tipoTransportistasInhabilitados = new ArrayList<>();
        for (TipoTransportista ttr : tiposTransportista){
            if(ttr.getEstado() == TipoTransportista.Estado.Invalido){
                tipoTransportistasInhabilitados.add(ttr);
            }
        }
        return tipoTransportistasInhabilitados;    }

    @Override
    public TipoTransportista findOne(String descripcion) {
        TipoTransportista tipoTransportista = null;
        for (TipoTransportista ttr : tiposTransportista) {
            if (ttr.getDescripcion().equals(descripcion)) {
                tipoTransportista = ttr;
            }
        }
        return tipoTransportista;
    }

    @Override
    public void delete(String descripcion) {
        if (findOne(descripcion) != null) {
            findOne(descripcion).setEstado(TipoTransportista.Estado.Invalido);
        }
    }
}
