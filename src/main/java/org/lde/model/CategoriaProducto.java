package org.lde.model;

public class CategoriaProducto {
    private String descripcion;

    public CategoriaProducto(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "descripcion='" + descripcion + '\'' ;
    }
}
