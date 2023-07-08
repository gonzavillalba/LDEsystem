package org.lde.controller;

import org.lde.model.Pedido;
import org.lde.service.PedidoService;

public class PedidoController implements CRUD<Pedido> {
    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Override
    public void create(Pedido pedido) {
        pedidoService.save(pedido);
    }

    @Override
    public void findOne(String id) {

    }

    @Override
    public void findAll() {

    }

    @Override
    public void findAllOff() {

    }

    @Override
    public void upDate(Pedido pedido) {

    }

    @Override
    public void delete(String id) {

    }
}
