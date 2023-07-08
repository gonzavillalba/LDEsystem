package org.lde.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class Transportista {
    private String cuit;
    private String nombre;
    private String telefono;
    private String email;
    private TipoTransportista tipo;
    private Estado estado;
    public enum Estado{
        Habilitado,
        Invalido
    }

    public Transportista(String cuit, String nombre, String telefono, String email, TipoTransportista tipo) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.tipo = tipo;
        this.estado = Estado.Habilitado;
    }

    @Override
    public String toString() {
        return "cuit: '" + cuit + '\'' +
                ", nombre: '" + nombre + '\'' +
                ", telefono: '" + telefono + '\'' +
                ", email: '" + email + '\'' +
                ", tipo: " + tipo;
    }
}
