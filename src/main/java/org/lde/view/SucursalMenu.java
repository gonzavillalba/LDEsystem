package org.lde.view;

import org.lde.controller.SucursalController;
import org.lde.model.Sucursal;
import org.lde.model.Ubicacion;
import org.lde.repository.SectorRepository;
import org.lde.repository.SucursalRepository;
import org.lde.service.SucursalService;

import java.util.Scanner;

public class SucursalMenu {
    private final SucursalController sucursalController;
    SectorRepository sectorRepository = new SectorRepository();
    public SucursalMenu() {

        SucursalRepository sucursalRepository = new SucursalRepository();
        SucursalService sucursalService = new SucursalService(sucursalRepository);
        this.sucursalController = new SucursalController(sucursalService);
        menuSucursal();
    }

    public void menuSucursal(){

        Scanner leer = new Scanner(System.in);
        int opcion;
        Boolean salir = false;
        /////////////////////////////////////////////////////////////////////
        while (!salir){
            System.out.println("=============== Menu ====================");
            System.out.println("1.Cargar nueva sucursal");
            System.out.println("2.Ver todas las sucursales");
            System.out.println("3.Ver todas las sucursales inhabilitadas");
            System.out.println("4.Editar sucursal existente");
            System.out.println("5.Buscar sucursal por ID o nombre");
            System.out.println("6.Eliminar producto");
            System.out.println("7.Salir");
            System.out.println("=========================================");
            System.out.println("Ingrese una opcion: ");
            opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el codigo de la nueva sucursal: ");
                    String cod = leer.nextLine();
                    System.out.println("Ingrese el nombre de la nueva sucursal: ");
                    String nom = leer.nextLine();
                    System.out.println("Ingrese la direccion de la nueva sucursal: ");
                    String direc = leer.nextLine();
                    System.out.println("Ingrese el telefono de la nueva sucursal: ");
                    String tel = leer.nextLine();
                    System.out.println("Ingrese el email de la nueva sucursal: ");
                    String email = leer.nextLine();
                    System.out.println("Ingrese la latitud de la nueva sucursal: ");
                    float lat = leer.nextFloat();
                    System.out.println("Ingrese la longitud de la nueva sucursal");
                    float lon = leer.nextFloat();
                    Sucursal sucurX = new Sucursal(cod,nom,direc,tel,email,new Ubicacion(lat,lon));
                    sucurX.setSectores(sectorRepository.getSectores());
                    sucursalController.create(sucurX);
                    break;

                case 2:
                    System.out.println("============== Las sucursales son: ===============");
                    sucursalController.findAll();
                    break;

                case 3:
                    System.out.println("============== Las sucursales inhabilitadas son: ===============");
                    sucursalController.findAllOff();
                    break;

                case 4: System.out.println("Ingrese el Id de la sucursal a editar: ");
                    String codSuc = leer.nextLine();

                         System.out.println("Ingrese el nuevo nombre de la sucursal: ");
                         String nomUd = leer.nextLine();
                         System.out.println("Ingrese la nueva direccion: ");
                         String dir = leer.nextLine();
                         System.out.println("Ingrese el nuevo telefono: ");
                         String telUd = leer.nextLine();
                         System.out.println("Ingrese el nuevo email");
                         String emailUd = leer.nextLine();
                         System.out.println("Ingrese la nueva latitud: ");
                         float latUd = leer.nextFloat();
                         System.out.println("Ingrese la nueva longitud: ");
                         float longi = leer.nextFloat();
                         Sucursal suc = new Sucursal(codSuc,nomUd,dir,telUd,emailUd,new Ubicacion(latUd,longi));
                         suc.setSectores(sectorRepository.getSectores());
                         sucursalController.upDate(suc);

                    break;

                case 5: System.out.println("Ingrese el id o nombre de la sucursal buscada: ");
                    String nomId = leer.nextLine();
                    sucursalController.findOne(nomId);
                    break;

                case 6: System.out.println("Ingrese el Id de la sucursal a eliminar: ");
                    String id = leer.nextLine();
                    sucursalController.delete(id);
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
