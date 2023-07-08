package org.lde.controller;

import org.lde.model.TipoTransportista;
import org.lde.service.TipoTransportistaService;

public class TipoTranspController implements CRUD<TipoTransportista>{
    TipoTransportistaService tipoTransportistaService;

    public TipoTranspController(TipoTransportistaService tipoTransportistaService) {
        this.tipoTransportistaService = tipoTransportistaService;
    }

    @Override
    public void create(TipoTransportista tipoTransportista) {
        tipoTransportistaService.save(tipoTransportista);
    }

    @Override
    public void findOne(String id) {
        tipoTransportistaService.findOne(id);

    }

    @Override
    public void findAll() {
        tipoTransportistaService.findAll();

    }

    @Override
    public void findAllOff() {
        tipoTransportistaService.findAllOff();

    }

    @Override
    public void upDate(TipoTransportista tipoTransportista) {
        tipoTransportistaService.upDate(tipoTransportista);

    }

    @Override
    public void delete(String id) {
        tipoTransportistaService.delete(id);

    }
}
