package org.lde.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Ubicacion {
    private float latitud;
    private float longitud;

    public Ubicacion(float latitud, float longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return
                "latitud:" + latitud +
                ", longitud:" + longitud;
    }
}
