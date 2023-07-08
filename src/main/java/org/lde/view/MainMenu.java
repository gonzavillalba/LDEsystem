package org.lde.view;

import java.util.Scanner;

public class MainMenu {
    public MainMenu() {
        mainMenu();
    }

    public void mainMenu(){
        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        while (!salir){
            System.out.println("=========== MAIN MENÚ ===============");
            System.out.println("1. Gestion de Clientes");
            System.out.println("2. Gestion de Proveedores");
            System.out.println("3. Gestion de Transportistas");
            System.out.println("4. Gestion de Productos");
            System.out.println("5. Gestion de Sucursales");
            System.out.println("6.Salir");
            System.out.println("=========================================");
            System.out.println("Ingrese una opcion: ");
            int opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion){
                case 1:
                    ClienteMenu clienteMenu = new ClienteMenu();
                    break;
                case 2:
                    ProveedorMenu proveedorMenu = new ProveedorMenu();
                    break;

                case 3:
                    TransportistaMenu transportistaMenu = new TransportistaMenu();
                    break;

                case 4:
                    ProductoMenu productoMenu = new ProductoMenu();
                    break;

                case 5:
                    SucursalMenu sucursalMenu = new SucursalMenu();
                    break;

                case 6:
                    EmpleadoMenu empleadoMenu = new EmpleadoMenu();

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
