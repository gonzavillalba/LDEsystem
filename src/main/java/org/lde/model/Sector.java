package org.lde.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class Sector {
    private String codSector;
    private String descripcion;
    private Sector.Estado estado;
    public enum Estado{
        Habilitado,
        Invalido
    }


    public Sector(String codSector, String descripcion) {
        this.codSector = codSector;
        this.descripcion = descripcion;
        this.estado = Sector.Estado.Habilitado;
    }

    @Override
    public String toString() {
        return "codSector=" + codSector +
                ", descripcion='" + descripcion + '\'';
    }
}
