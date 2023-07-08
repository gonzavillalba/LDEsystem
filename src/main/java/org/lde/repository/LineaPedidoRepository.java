package org.lde.repository;

import org.lde.model.LineaPedido;
import org.lde.model.Producto;

import java.util.List;

public class LineaPedidoRepository implements CRUD<LineaPedido>{
    public List<LineaPedido> lineasPedido;
    ProductoRepository productoRepository = new ProductoRepository();

    @Override
    public void upLoad() {

    }

    @Override
    public void save(LineaPedido lineaPedido) {
        lineasPedido.add(lineaPedido);
    }

    @Override
    public void upDate(LineaPedido lineaPedido) {


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
    public LineaPedido findOne(String descProd) {
        LineaPedido lineaPedido = null;
        Producto pd = productoRepository.findOne(descProd);
        for (LineaPedido lpr : lineasPedido){
            if (lpr.getProducto().equals(pd)){
                lineaPedido = lpr;
            }
        }
        return lineaPedido;
    }

    @Override
    public void delete(String cuit) {

    }
}
