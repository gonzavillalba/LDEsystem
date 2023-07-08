package org.lde.view;

import org.lde.controller.ProveedorController;
import org.lde.model.Proveedor;
import org.lde.repository.ClienteRepository;
import org.lde.repository.ProveedorRepository;
import org.lde.service.ClienteService;
import org.lde.service.ProveedorService;

import java.util.Scanner;

public class ProveedorMenu {
    public ProveedorMenu() {
        menuProveedor();
    }

    public void menuProveedor(){
        ProveedorRepository proveedorRepository = new ProveedorRepository();
        ProveedorService proveedorService = new ProveedorService(proveedorRepository);
        ProveedorController proveedorController = new ProveedorController(proveedorService);
        Scanner leer = new Scanner(System.in);
        Boolean salir = false;
        ////////////////////////////////////////////////////////////////////
        while (!salir) {
            System.out.println("=============== Menu ====================");
            System.out.println("1.Crear proveedor");
            System.out.println("2.Ver todos los proveedores");
            System.out.println("3.Ver todos los proveedores Inhabilitados");
            System.out.println("4.Editar proveedor");
            System.out.println("5.Buscar proveedor por C.U.I.T.");
            System.out.println("6.Eliminar proveedor");
            System.out.println("7.Salir");
            System.out.println("=========================================");
            System.out.println("Ingrese una opcion: ");
            int opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el C.U.I.T: ");
                    String cuit = leer.nextLine();
                    System.out.println("Ingrese el nombre del proveedor: ");
                    String nombre = leer.nextLine();
                    System.out.println("Ingrese la direccion del proveedor: ");
                    String direc = leer.nextLine();
                    System.out.println("Inrese el numero de telefono del proveedor: ");
                    String tel = leer.nextLine();
                    System.out.println("Inrese el numero de email del proveedor: ");
                    String email = leer.nextLine();
                    proveedorController.create(new Proveedor(cuit,nombre,direc,tel,email));
                    break;

                case 2:
                    System.out.println("============== La lista de Proveedores actuales es: ===============");
                    proveedorController.findAll();
                    break;

                case 3:
                    System.out.println("=============== La lista de Proveedores Invalidos es: ============");
                    proveedorController.findAllOff();
                    break;

                case 4: System.out.println("Ingrese el C.U.I.T: ");
                    String cuitPr = leer.nextLine();
                    System.out.println("Ingrese el nombre del proveedor: ");
                    String nombr = leer.nextLine();
                    System.out.println("Ingrese la direccion del proveedor: ");
                    String dire = leer.nextLine();
                    System.out.println("Inrese el numero de telefono del proveedor: ");
                    String telP = leer.nextLine();
                    System.out.println("Inrese el numero de email del proveedor: ");
                    String emailP = leer.nextLine();
                    proveedorController.upDate(new Proveedor(cuitPr,nombr,dire,telP,emailP));
                    break;

                case 5:
                    System.out.println("Ingrese el C.U.I.T. del proveedor a Buscar: ");
                    String cuitP = leer.nextLine();
                    proveedorController.findOne(cuitP);
                    break;

                case 6:
                    System.out.println("Ingrese el C.U.I.T. del proveedor a eliminar: ");
                    String cuitd = leer.nextLine();
                    proveedorController.delete(cuitd);
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
