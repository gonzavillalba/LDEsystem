package org.lde.service;

import org.lde.model.Sucursal;
import org.lde.repository.SectorRepository;
import org.lde.repository.SucursalRepository;

import java.util.ArrayList;
import java.util.List;

public class SucursalService implements CRUD<Sucursal> {
    SucursalRepository sucursalRepository;
    SectorRepository sectorRepository = new SectorRepository();

    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    public void save(Sucursal sucursal) {
        int contador = 0;

        for (Sucursal sr : findAll()) {
            if (sr.getCodSucursal().equals(sucursal.getCodSucursal())) {
                contador++;
            }
        }

        if (contador == 0) {
            sucursalRepository.save(sucursal);
            System.out.println("VVVVVVVVVV La sucursal ha sido creado con exito VVVVVVVVVVVV");
        }else {
            System.out.println("XXXXXXXXXXXXXXXX La sucursal ya existe XXXXXXXXXXXXXXXXXXX");
        }
    }

    @Override
    public void upDate(Sucursal sucursal) {
        int cont = 0;
        for (Sucursal sr : findAll()){
            if (sr.getCodSucursal().equals(sucursal.getCodSucursal())){
                cont++;
            }
        }
        if (cont == 0){
            System.out.println("XXXXXXXXXXXXXXXXX La sucursal ingresada no existe XXXXXXXXXXXXXXXXX");
        }else {
            sucursalRepository.upDate(sucursal);
        }

    }

    @Override
    public Sucursal findOne(String cuit) {
        Sucursal suc = null;
        int cont = 0;
        for(Sucursal sr : sucursalRepository.getSucursales()){
            if(sr.getCodSucursal().equals(cuit) || sr.getNombre().equals(cuit)){
                suc = sr;
                cont++;
            }
        }
        if (cont == 0) {
            System.out.println("XXXXXXXXXXXXX La sucursal buscada no existe XXXXXXXXXXX");
        }else {
            System.out.println("La sucursal buscada es: " + sucursalRepository.findOne(cuit));
        }
        return suc;
    }

    @Override
    public List<Sucursal> findAll() {
        List<Sucursal>sucursalsList = new ArrayList<>();
        for(Sucursal sr : sucursalRepository.findAll()){
            System.out.println(sr.toString());
        }

        return sucursalsList;
    }

    @Override
    public List<Sucursal> findAllOff() {
        List<Sucursal>sucursalsList = new ArrayList<>();
        for(Sucursal sr : sucursalRepository.findAllOff()){
            System.out.println(sr.toString());
        }

        return sucursalsList;
    }

    @Override
    public void delete(String cuit) {
        int cont = 0;
        for (Sucursal sr : findAll()){
            if (sr.getCodSucursal().equals(cuit)){
                cont++;
            }
        }
        if (cont == 0){
            System.out.println("XXXXXXXXXXXXXXXXXXX La sucursal ingresada no existe XXXXXXXXXXXXXXXXXX");
        }else {
            sucursalRepository.delete(cuit);
            System.out.println("VVVVVVVVVVVVVVVVVV La sucursal ha sido eliminada con exito VVVVVVVVVVVVVVVVVVV");
        }
    }
}
