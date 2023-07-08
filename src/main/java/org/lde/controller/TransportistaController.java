package org.lde.controller;

import org.lde.model.Cliente;
import org.lde.model.TipoTransportista;
import org.lde.model.Transportista;
import org.lde.service.TransportistaService;

import java.util.Scanner;

public class TransportistaController implements CRUD<Transportista>{
    TransportistaService transportistaService;
    Scanner leer = new Scanner(System.in);

    public TransportistaController(TransportistaService transportistaService) {
        this.transportistaService = transportistaService;
    }

    @Override
    public void create(Transportista transportista) {

        transportistaService.save(transportista);

    }

    @Override
    public void findOne(String cuit) {
        transportistaService.findOne(cuit);
    }

    @Override
    public void findAll() {
        transportistaService.findAll();

    }

    @Override
    public void findAllOff() {
        transportistaService.findAllOff();
    }

    @Override
    public void upDate(Transportista transportista) {

        transportistaService.upDate(transportista);
    }

    @Override
    public void delete(String cuit) {

        transportistaService.delete(cuit);
    }
}
