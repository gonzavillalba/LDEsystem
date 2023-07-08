package org.lde.view;

import org.lde.controller.ClienteController;
import org.lde.model.Cliente;
import org.lde.repository.ClienteRepository;
import org.lde.service.ClienteService;

import java.util.Scanner;

public class ClienteMenu {
    public ClienteMenu() {
        menuCliente();
    }

    public void menuCliente(){
        ClienteRepository clienteRepository = new ClienteRepository();
        ClienteService clienteService = new ClienteService(clienteRepository);
        ClienteController clienteController = new ClienteController(clienteService);
        Scanner leer = new Scanner(System.in);
        Boolean salir = false;
        ////////////////////////////////////////////////////////////////////
        while (!salir) {
            System.out.println("=============== Menu ====================");
            System.out.println("1.Crear cliente");
            System.out.println("2.Ver todos los clientes");
            System.out.println("3.Ver todos los clientes Inhabilitados");
            System.out.println("4.Editar cliente");
            System.out.println("5.Buscar cliente por C.U.I.T.");
            System.out.println("6.Eliminar cliente");
            System.out.println("7.Salir");
            System.out.println("=========================================");
            System.out.println("Ingrese una opcion: ");
            int opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el C.U.I.T: ");
                    String cuit = leer.nextLine();
                    System.out.println("Ingrese el nombre del cliente: ");
                    String nombre = leer.nextLine();
                    System.out.println("Ingrese el apellido del cliente: ");
                    String apellido = leer.nextLine();
                    System.out.println("Ingrese la direccion: ");
                    String direc = leer.nextLine();
                    System.out.println("Inrese el numero de telefono del cliente: ");
                    String telC = leer.nextLine();
                    clienteController.create(new Cliente(cuit,nombre,apellido,direc,telC));
                    break;

                case 2:
                    System.out.println("============== La lista de Clientes actuales es: ===============");
                    clienteController.findAll();
                    break;

                case 3:
                    System.out.println("=============== La lista de Clientes Invalidos es: ============");
                    clienteController.findAllOff();
                    break;

                case 4:
                    System.out.println("Ingrese el C.U.I.T. del cliente a editar: ");
                    String idc = leer.nextLine();
                    System.out.println("Ingrese el nuevo nombre del cliente: ");
                    String nom = leer.nextLine();
                    System.out.println("Ingrese el nuevo apellido del cliente: ");
                    String ape = leer.nextLine();
                    System.out.println("Ingrese la nueva direccion del cliente: ");
                    String dire = leer.nextLine();
                    System.out.println("Ingrese el nuevo telefono del cliente: ");
                    String tel = leer.nextLine();
                    clienteController.upDate(new Cliente(idc,nom,ape,dire,tel));
                    break;

                case 5:
                    System.out.println("Ingrese el C.U.I.T. del cliente a Buscar: ");
                    String cuitc = leer.nextLine();
                    clienteController.findOne(cuitc);
                    break;

                case 6:
                    System.out.println("Ingrese el C.U.I.T. del cliente a eliminar: ");
                    String cuitd = leer.nextLine();
                    clienteController.delete(cuitd);
                    break;

                case 7:
                    salir = true;
                    System.out.println("Ha salido exitosamente");
                    break;

                default:
                    System.out.println("La opcion ingresada no existe, intente nuevamente..");
            }

        }

    }



}
