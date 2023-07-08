package org.lde.controller;

import lombok.Getter;
import lombok.Setter;
import org.lde.model.Cliente;
import org.lde.service.ClienteService;

import java.util.Scanner;

@Getter
@Setter

public class ClienteController implements CRUD<Cliente> {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    public void create(Cliente cliente){
        clienteService.save(cliente);
    }
    public void findAll(){
        clienteService.findAll();
    }
    public void findAllOff(){

        clienteService.findAllOff();
    }
    public void findOne(String cuit){
        clienteService.findOne(cuit);
    }
    public void upDate(Cliente cliente){
        clienteService.upDate(cliente);
    }
    public void delete(String cuit){
        clienteService.delete(cuit);
    }
}
