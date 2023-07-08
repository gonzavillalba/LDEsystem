package org.lde.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter

public class Pedido {
    private String numeroPedido;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Cliente cliente;
    private Transportista transportista;
    private Empleado empleado;
    private boolean enTransito;
    public List<LineaPedido>lineasDePedidos;
    public List<Ubicacion>ubicaciones;
    private Sector sectorOrigen;
    private Sector sectorDestino;
    private String estadoPedido;
    private String tracking;

    public Pedido(LocalDate fechaInicio, Cliente cliente, Transportista transportista) {
        this.numeroPedido = numeroPedido;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cliente = cliente;
        this.transportista = transportista;
        this.empleado = empleado;
        this.enTransito = false;
        this.sectorOrigen = sectorOrigen;
        this.sectorDestino = sectorDestino;
        this.estadoPedido = estadoPedido;
        this.tracking = tracking;
        this.lineasDePedidos = new ArrayList<>();
        this.ubicaciones = new ArrayList<>();
    }
   /* public String randomCode(){
        Random random = new Random();
        int codigo = random.nextInt(900000) + 100000;
        return String.valueOf(codigo);
    }*/

    @Override
    public String toString() {
        return "numeroPedido: '" + numeroPedido + '\'' +
                ", fechaInicio: " + fechaInicio +
                ", fechaFin: " + fechaFin +
                ", cliente: " + cliente +
                ", transportista: " + transportista  +
                ", empleado: " + empleado +
                ", lineasDePedidos: " + lineasDePedidos +
                ", ubicaciones: " + ubicaciones +
                ", sectorOrigen: " + sectorOrigen +
                ", sectorDestino: " + sectorDestino +
                ", estadoPedido: '" + estadoPedido + '\'' ;
    }
}
