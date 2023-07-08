package org.lde.service;

import org.lde.model.Cliente;
import org.lde.model.Pedido;
import org.lde.repository.PedidoRepository;

import java.util.List;

public class PedidoService implements CRUD<Pedido> {
    PedidoRepository pedidoRepository = new PedidoRepository();

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void save(Pedido pedido) {
        int contador = 0;

        for (Pedido pr : findAll()) {
            if (pr.getNumeroPedido().equals(pedido.getNumeroPedido())) {
                contador++;
            }
        }

        if (contador == 0) {
            pedidoRepository.save(pedido);
            System.out.println("VVVVVVVVVV El pedido ha sido creado con exito VVVVVVVVVVVV");
        }else{
            System.out.println("XXXXXXXXXXXXXXXX El pedido ya existe XXXXXXXXXXXXXXXXXXX");
        }

    }

    @Override
    public void upDate(Pedido pedido) {

    }

    @Override
    public Pedido findOne(String cuit) {
        return null;
    }

    @Override
    public List<Pedido> findAll() {
        return null;
    }

    @Override
    public List<Pedido> findAllOff() {
        return null;
    }

    @Override
    public void delete(String cuit) {

    }
}
