package org.lde.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class LineaPedido {
    private Producto producto;
    private int cantidad;
    private int calificacion;

    public LineaPedido(Producto producto, int cantidad, int calificacion) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return  "producto: " + producto +
                ", cantidad: " + cantidad +
                ", calificacion: " + calificacion;
    }
}

