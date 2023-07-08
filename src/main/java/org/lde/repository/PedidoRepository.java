package org.lde.repository;

import org.lde.model.*;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository implements CRUD<Pedido> {
    List<Pedido>pedidos;

    @Override
    public void upLoad() {

    }

    @Override
    public void save(Pedido pedido) {
        pedidos.add(pedido);

    }

    @Override
    public void upDate(Pedido pedido) {
        if (findOne(pedido.getNumeroPedido()) != null){
            findOne(pedido.getNumeroPedido()).setLineasDePedidos(pedido.getLineasDePedidos());
        }

    }

    @Override
    public List<Pedido> findAll() {
        List<Pedido>pedidoList = new ArrayList<>();
        for (Pedido pr : pedidos){
            pedidoList.add(pr);
        }
        return pedidoList;
    }

    @Override
    public List<Pedido> findAllOff() {
        return null;
    }

    @Override
    public Pedido findOne(String cuit) {
        Pedido pedido = null;
        for (Pedido pr : pedidos){
            if (pr.getNumeroPedido().equals(cuit)){
                pedido = pr;
            }
        }
        return pedido;
    }

    @Override
    public void delete(String cuit) {
        if (findOne(cuit) != null){
            pedidos.remove(findOne(cuit));
        }
    }
    public void agregarLineaPedido(String id, LineaPedido lineaPedido){
        findOne(id).getLineasDePedidos().add(lineaPedido);
    }
    public void agregarUbicacion(String id, Ubicacion ubicacion){
        findOne(id).getUbicaciones().add(ubicacion);
    }
    public void modificarSectores(String id, Sector origenNew, Sector destNew){
        findOne(id).setSectorOrigen(origenNew);
        findOne(id).setSectorDestino(destNew);
    }
    public void agregarEmpleado(String id, Empleado empleado){
        findOne(id).setEmpleado(empleado);
    }
}
