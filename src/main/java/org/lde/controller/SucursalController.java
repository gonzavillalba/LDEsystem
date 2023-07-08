package org.lde.controller;

import org.lde.model.Sucursal;
import org.lde.model.Ubicacion;
import org.lde.repository.SectorRepository;
import org.lde.service.SucursalService;

import java.util.Scanner;

public class SucursalController implements CRUD<Sucursal>{
    SucursalService sucursalService;
    SectorRepository sectorRepository = new SectorRepository();
    Scanner leer = new Scanner(System.in);

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @Override
    public void create(Sucursal sucursal) {

        sucursalService.save(sucursal);
    }



    @Override
    public void findOne(String id) {
        sucursalService.findOne(id);

    }

    @Override
    public void findAll() {
        sucursalService.findAll();
    }

    @Override
    public void findAllOff() {
        sucursalService.findAllOff();
    }

    @Override
    public void upDate(Sucursal sucursal) {
        sucursalService.upDate(sucursal);
    }

    @Override
    public void delete(String id) {
        sucursalService.delete(id);
    }




}
