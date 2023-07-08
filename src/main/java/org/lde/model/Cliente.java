package org.lde.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public class Cliente {
    private String CUIT;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
   private Estado estado;

    public List<Pedido>pedidos;
    public enum Estado{
        Habilitado,
        Invalido
    }
    public Cliente(String CUIT, String nombre, String apellido, String direccion, String telefono) {
        this.CUIT = CUIT;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = Estado.Habilitado;
        this.pedidos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "CUIT: '" + CUIT + '\'' +
                ", nombre: '" + nombre + '\'' +
                ", apellido: '" + apellido + '\'' +
                ", direccion: '" + direccion + '\'' +
                ", telefono: '" + telefono + '\'' +
                ", estado: " + estado;
    }
    public List<Pedido>getPedidos(){
        return pedidos;
    }
}
