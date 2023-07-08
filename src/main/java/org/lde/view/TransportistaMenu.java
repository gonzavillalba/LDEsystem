package org.lde.view;

import org.lde.controller.TransportistaController;
import org.lde.model.TipoTransportista;
import org.lde.model.Transportista;
import org.lde.repository.TransportistaRepository;
import org.lde.service.TransportistaService;

import java.util.Scanner;

public class TransportistaMenu {
    public TransportistaMenu() {
        menuTransportista();
    }

    public void menuTransportista(){

        TransportistaRepository transportistaRepository = new TransportistaRepository();
        TransportistaService transportistaService = new TransportistaService(transportistaRepository);
        TransportistaController transportistaController = new TransportistaController(transportistaService);
        Scanner leer = new Scanner(System.in);
        Boolean salir = false;
        ////////////////////////////////////////////////////////////////////
        while (!salir) {
            System.out.println("=============== Menu ====================");
            System.out.println("1.Crear transportista");
            System.out.println("2.Ver todos los transportistas");
            System.out.println("3.Ver todos los transportistas Inhabilitados");
            System.out.println("4.Editar transportista");
            System.out.println("5.Buscar transportista por C.U.I.T.");
            System.out.println("6.Eliminar transportista");
            System.out.println("7.Salir");
            System.out.println("=========================================");
            System.out.println("Ingrese una opcion: ");
            int opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1: System.out.println("Ingrese el C.U.I.T: ");
                    String cuit = leer.nextLine();
                    System.out.println("Ingrese el nombre del transportista: ");
                    String nombre = leer.nextLine();
                    System.out.println("Ingrese el telefono del transportista: ");
                    String telefono = leer.nextLine();
                    System.out.println("Ingrese el email del transportista: ");
                    String email = leer.nextLine();
                    System.out.println("Inrese el tipo de transportista: ");
                    String tipo = leer.nextLine();
                    transportistaController.create(new Transportista(cuit,nombre,telefono,email,new TipoTransportista(tipo)));
                    break;

                case 2:
                    System.out.println("============= La lista actual de transportistas es =============");
                    transportistaController.findAll();
                    break;

                case 3:
                    System.out.println("============= La lista actual de transportistas inhabilitados es =============");
                    transportistaController.findAllOff();
                    break;

                case 4: System.out.println("Ingrese el C.U.I.T. del transportista a editar: ");
                    String cuitT = leer.nextLine();
                    System.out.println("Ingrese el nuevo nombre del transportista: ");
                    String nom = leer.nextLine();
                    System.out.println("Ingrese el nuevo telefono del transportista: ");
                    String tel = leer.nextLine();
                    System.out.println("Ingrese el nuevo email del transportista: ");
                    String emailt = leer.nextLine();
                    System.out.println("Ingrese el nuevo tipo del transportista: ");
                    String tipot = leer.nextLine();
                    transportistaController.upDate(new Transportista(cuitT,nom,tel,emailt,new TipoTransportista(tipot)));
                    break;

                case 5: System.out.println("Ingrese el C.U.I.T. del transportista a Buscar: ");
                    String id = leer.nextLine();
                    transportistaController.findOne(id);
                    break;

                case 6: System.out.println("Ingrese el C.U.I.T. del transportista a eliminar: ");
                    String cuitD = leer.nextLine();
                    transportistaController.delete(cuitD);
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
