package org.lde.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class Producto {
    private Proveedor proveedor;
    private CategoriaProducto categoria;
    private String idPreoducto;
    private String descripcion;
    private float altura;
    private float ancho;
    private float longitud;
    private float peso;
    private Estado estado;

    public enum Estado{
        Habilitado,
        Invalido
    }

    public Producto( String idPreoducto,Proveedor proveedor, CategoriaProducto categoria, String descripcion, float altura, float ancho, float longitud, float peso) {
        this.idPreoducto = idPreoducto;
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.altura = altura;
        this.ancho = ancho;
        this.longitud = longitud;
        this.peso = peso;
        estado = Estado.Habilitado;
    }

    @Override
    public String toString() {
        return "idPreoducto: '" + idPreoducto + '\'' +
                ", descripcion: '" + descripcion + '\'' +
                ", proveedor:" + proveedor +
                ", categoria: " + categoria +
                ", altura: " + altura +
                ", ancho: " + ancho +
                ", longitud: " + longitud +
                ", peso: " + peso +
                ", estado: " + estado;
    }
}
