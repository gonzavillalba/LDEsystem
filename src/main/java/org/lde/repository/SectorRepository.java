package org.lde.repository;

import lombok.Getter;
import lombok.Setter;
import org.lde.model.Producto;
import org.lde.model.Sector;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class SectorRepository implements CRUD<Sector>{
    public List<Sector> sectores;

    public SectorRepository() {
        sectores = new ArrayList<>();
    }

    @Override
    public void upLoad() {
        List<Sector>sectorList = new ArrayList<>();
        Sector sec1 = new Sector("1","Pendiente");
        Sector sec2 = new Sector("2","Proceso");
        Sector sec3 = new Sector("3","Completado");
        Sector sec4 = new Sector("4","Despacho");
        Sector sec5 = new Sector("5","Entrega");

        sectores.add(sec1);
        sectores.add(sec2);
        sectores.add(sec3);
        sectores.add(sec4);
        sectores.add(sec5);
    }

    @Override
    public void save(Sector sector) {
        sectores.add(sector);
    }

    @Override
    public void upDate(Sector sector) {
        for(Sector sr : sectores){
            if (sr.getCodSector().equals(sector.getCodSector())){
                sr.setDescripcion(sector.getDescripcion());
            }

        }
    }

    @Override
    public List<Sector> findAll() {
        List<Sector>sectoresHabilitados = new ArrayList<>();
        for (Sector sr : sectores){
            if(sr.getEstado().equals(Sector.Estado.Habilitado)){
                sectoresHabilitados.add(sr);
            }
        }
        return sectoresHabilitados;
    }

    @Override
    public List<Sector> findAllOff() {
        List<Sector>sectoresInhabilitados = new ArrayList<>();
        for (Sector sr : sectores){
            if(sr.getEstado().equals(Sector.Estado.Invalido)){
                sectoresInhabilitados.add(sr);
            }
        }
        return sectoresInhabilitados;
    }

    @Override
    public Sector findOne(String cuit) {
        Sector sector = null;
        for (Sector sr : sectores){
            if (sr.getCodSector().equals(cuit) || sr.getDescripcion().equals(cuit)){
                sector = sr;
            }
        }
        return sector;
    }

    @Override
    public void delete(String cuit) {
        for (Sector sr : sectores){
            if (sr.getCodSector().equals(cuit)){
                sr.setEstado(Sector.Estado.Invalido);
            }
        }
    }
}
