package org.lde.view;

import org.lde.controller.EmpleadoController;
import org.lde.model.Empleado;
import org.lde.repository.EmpleadoRepository;
import org.lde.service.EmpleadoService;

import java.util.Scanner;

public class EmpleadoMenu {
    public EmpleadoMenu() {
        menuEmpleado();
    }

    public void menuEmpleado(){
        EmpleadoRepository empleadoRepository = new EmpleadoRepository();
        EmpleadoService empleadoService = new EmpleadoService(empleadoRepository);
        EmpleadoController empleadoController = new EmpleadoController(empleadoService);
        Scanner leer = new Scanner(System.in);
        Boolean salir = false;
        ////////////////////////////////////////////////////////////////////
        while (!salir) {
            System.out.println("=============== Menu ====================");
            System.out.println("1.Crear empleado");
            System.out.println("2.Ver todos los empleados");
            System.out.println("3.Ver todos los empleado Inhabilitados");
            System.out.println("4.Editar empleado");
            System.out.println("5.Buscar empleado por DNI");
            System.out.println("6.Eliminar empleado");
            System.out.println("7.Salir");
            System.out.println("=========================================");
            System.out.println("Ingrese una opcion: ");
            int opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el C.U.I.T: ");
                    String cuit = leer.nextLine();
                    System.out.println("Ingrese el nombre del empleado: ");
                    String nombre = leer.nextLine();
                    System.out.println("Ingrese el apellido del empleado: ");
                    String apellido = leer.nextLine();
                    System.out.println("Ingrese la direccion: ");
                    String direc = leer.nextLine();
                    System.out.println("Inrese el numero de telefono del empleado: ");
                    String telC = leer.nextLine();
                    empleadoController.create(new Empleado(cuit,nombre,apellido,direc,telC));
                    break;

                case 2:
                    System.out.println("============== La lista de empleados actuales es: ===============");
                    empleadoController.findAll();
                    break;

                case 3:
                    System.out.println("=============== La lista de empleados Invalidos es: ============");
                    empleadoController.findAllOff();
                    break;

                case 4:
                    System.out.println("Ingrese el C.U.I.T. del empleado a editar: ");
                    String idc = leer.nextLine();
                    System.out.println("Ingrese el nuevo nombre del empleado: ");
                    String nom = leer.nextLine();
                    System.out.println("Ingrese el nuevo apellido del empleado: ");
                    String ape = leer.nextLine();
                    System.out.println("Ingrese la nueva direccion del empleado: ");
                    String dire = leer.nextLine();
                    System.out.println("Ingrese el nuevo telefono del empleado: ");
                    String tel = leer.nextLine();
                    empleadoController.upDate(new Empleado(idc,nom,ape,dire,tel));
                    break;

                case 5:
                    System.out.println("Ingrese el C.U.I.T. del empleado a Buscar: ");
                    String cuitc = leer.nextLine();
                    empleadoController.findOne(cuitc);
                    break;

                case 6:
                    System.out.println("Ingrese el C.U.I.T. del empleado a eliminar: ");
                    String cuitd = leer.nextLine();
                    empleadoController.delete(cuitd);
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
