package org.lde.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class TipoTransportista {
    private String descripcion;
    private Estado estado;

    public enum Estado{
        Habilitado,
        Invalido
    }

    public TipoTransportista(String descripcion) {
        this.descripcion = descripcion;
        this.estado = Estado.Habilitado;
    }

    @Override
    public String toString() {
        return "descripcion: '" + descripcion + '\'' ;
    }
}
