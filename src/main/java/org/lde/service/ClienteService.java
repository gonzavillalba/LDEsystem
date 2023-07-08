package org.lde.service;

import lombok.Getter;
import lombok.Setter;
import org.lde.model.Cliente;
import org.lde.repository.ClienteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter

public class ClienteService implements CRUD<Cliente>{
    ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    public void save(Cliente cliente) {
        int contador = 0;

        for (Cliente cr : findAll()) {
            if (cr.getCUIT().equals(cliente.getCUIT())) {
                contador++;
            }
        }

        if (contador == 0) {
            clienteRepository.save(cliente);
            System.out.println("VVVVVVVVVV El cliente ha sido creado con exito VVVVVVVVVVVV");
        }else{
            System.out.println("XXXXXXXXXXXXXXXX El cliente ya existe XXXXXXXXXXXXXXXXXXX");
        }


    }
    public List<Cliente>findAll(){
        List<Cliente>clienteList = new ArrayList<>();
        for(Cliente cr : clienteRepository.findAll()){
            System.out.println(cr.toString());
        }

        return clienteList;
    }
    public List<Cliente>findAllOff(){
        List<Cliente>clienteList = new ArrayList<>();
        for(Cliente cr : clienteRepository.findAllOff()){
            System.out.println(cr.toString());
        }

        return clienteList;
    }
    public Cliente findOne(String cuit){
        Cliente cliente = null;
        int cont = 0;
        for(Cliente cr : findAll()){
           if(cr.getCUIT().equals(cuit)){
               cont++;
               cliente = cr;
           }
        }
        if (cont == 0) {
            System.out.println("XXXXXXXXXXXXX El cliente buscado no existe XXXXXXXXXXX");
        }else{
            System.out.println("El cliente buscado es: " + clienteRepository.findOne(cuit));
        }
        return cliente;
    }
    public void upDate(Cliente cliente){
        int cont = 0;
        for(Cliente cr : findAll()){
            if(cr.getCUIT().equals(cliente.getCUIT())){
                cont++;
            }
        }
        if(cont == 0){
            System.out.println("XXXXXXXXXXXXXXXXX El cliente ingresado no existe XXXXXXXXXXXXXXXXX");
        }else{

            clienteRepository.upDate(cliente);
        }
    }
    public void delete(String cuit){
        int cont = 0;
        for (Cliente cr : findAll()){
            if (cr.getCUIT().equals(cuit)) {
                cont++;
            }
        }
        if (cont == 0){
            System.out.println("XXXXXXXXXXXXXXXXXXX El cliente ingresado no existe XXXXXXXXXXXXXXXXXX");
        }else {
            clienteRepository.delete(cuit);
            System.out.println("VVVVVVVVVVVVVVVVVV El cliente ha sido eliminado con exito VVVVVVVVVVVVVVVVVVV");
        }
    }
}
