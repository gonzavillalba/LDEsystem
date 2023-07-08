package org.lde.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public class Sucursal {
    private String codSucursal;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private Ubicacion ubicacion;
    private Estado estado;

    public List<Sector> sectores;
    public enum Estado{
        Habilitado,
        Invalido
    }

    public Sucursal(String codSucursal, String nombre, String direccion, String telefono, String email, Ubicacion ubicacion) {
        this.codSucursal = codSucursal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.ubicacion = ubicacion;
        this.estado = Estado.Habilitado;
        this.sectores = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "codSucursal: '" + codSucursal + '\'' +
                ", nombre: '" + nombre + '\'' +
                ", direccion: '" + direccion + '\'' +
                ", telefono: '" + telefono + '\'' +
                ", email: '" + email + '\'' +
                ", ubicacion: " + ubicacion +
                ", estado: " + estado;
    }
}
