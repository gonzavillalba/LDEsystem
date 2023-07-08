package org.lde.repository;

import lombok.Getter;
import lombok.Setter;
import org.lde.model.Cliente;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class ClienteRepository implements CRUD <Cliente>{
    public List<Cliente>clientes;

    public ClienteRepository() {
        this.clientes = new ArrayList<>();
        upLoad();
    }

    @Override
    public void upLoad() {
        Cliente c1 = new Cliente("00","Pedro","Gonzalez","calle0","123");
        Cliente c2 = new Cliente("01","Pablo","Rodriguez","calle1","456");
        Cliente c3 = new Cliente("02","Patricio","Martinez","calle2","789");
        Cliente c4 = new Cliente("03","Pancho","Marquez","calle3","011");
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        clientes.add(c4);

    }

    public void save(Cliente clienteNew) {

        clientes.add(clienteNew);
    }


    public void upDate(Cliente clienteUD) {
            if(findOne(clienteUD.getCUIT()) != null){
                findOne(clienteUD.getCUIT()).setNombre(clienteUD.getNombre());
                findOne(clienteUD.getCUIT()).setApellido(clienteUD.getApellido());
                findOne(clienteUD.getCUIT()).setDireccion(clienteUD.getDireccion());
                findOne(clienteUD.getCUIT()).setTelefono(clienteUD.getTelefono());
            }

    }


    public Cliente findOne(String cuit) {
        Cliente cliente = null;
        for (Cliente cr : clientes){
            if (cr.getCUIT().equals(cuit)){
                cliente = cr;
            }
        }
        return cliente;
    }


    public List<Cliente> findAll() {
        List<Cliente>clientesHabilitados = new ArrayList<>();
        for(Cliente cr : clientes){
            if(cr.getEstado() == Cliente.Estado.Habilitado){
                clientesHabilitados.add(cr);
            }
        }
        return clientesHabilitados;
    }
    public List<Cliente> findAllOff() {
        List<Cliente>clientesInvalidos = new ArrayList<>();
        for(Cliente cr : clientes){
            if(cr.getEstado() == Cliente.Estado.Invalido){
                clientesInvalidos.add(cr);
            }
        }
        return clientesInvalidos;
    }


    public void delete(String cuit) {
            if(findOne(cuit) != null){
                findOne(cuit).setEstado(Cliente.Estado.Invalido);
            }

    }
}
