package org.lde.service;

import org.lde.model.LineaPedido;
import org.lde.repository.LineaPedidoRepository;

import java.util.List;

public class LineaPedidoService implements CRUD<LineaPedido>{
    LineaPedidoRepository lineaPedidoRepository;

    public LineaPedidoService(LineaPedidoRepository lineaPedidoRepository) {
        this.lineaPedidoRepository = lineaPedidoRepository;
    }

    @Override
    public void save(LineaPedido lineaPedido) {
        lineaPedidoRepository.save(lineaPedido);

    }

    @Override
    public void upDate(LineaPedido lineaPedido) {

    }

    @Override
    public LineaPedido findOne(String cuit) {
        return null;
    }

    @Override
    public List<LineaPedido> findAll() {
        return null;
    }

    @Override
    public List<LineaPedido> findAllOff() {
        return null;
    }

    @Override
    public void delete(String cuit) {

    }
}
