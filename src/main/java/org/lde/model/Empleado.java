package org.lde.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Empleado {
    private String CUIT;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private Estado estado;
    public enum Estado{
        Habilitado,
        Invalido
    }

    public Empleado(String CUIT, String nombre, String apellido, String direccion, String telefono) {
        this.CUIT = CUIT;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        estado = Estado.Habilitado;
    }

    @Override
    public String toString() {
        return "CUIT: '" + CUIT + '\'' +
                ", nombre: '" + nombre + '\'' +
                ", apellido: '" + apellido + '\'' +
                ", direccion: '" + direccion + '\'' +
                ", telefono: '" + telefono + '\'' +
                ", estado: " + estado ;
    }
}
