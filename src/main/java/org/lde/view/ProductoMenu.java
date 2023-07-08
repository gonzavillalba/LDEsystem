package org.lde.view;

import org.lde.controller.ProductoController;
import org.lde.model.CategoriaProducto;
import org.lde.model.Producto;
import org.lde.repository.ProductoRepository;
import org.lde.repository.ProveedorRepository;
import org.lde.service.ProductoService;

import java.util.Scanner;

public class ProductoMenu {
    ProveedorRepository proveedorRepository = new ProveedorRepository();
    public ProductoMenu() {
        menuProducto();
    }

    public void menuProducto(){
        ProductoRepository productoRepository = new ProductoRepository();
        ProductoService productoService = new ProductoService(productoRepository);
        ProductoController productoController = new ProductoController(productoService);
        Scanner leer = new Scanner(System.in);
        Boolean salir = false;
        /////////////////////////////////////////////////////////////////////
        while (!salir){
            System.out.println("=============== Menu ====================");
            System.out.println("1.Cargar nuevo producto");
            System.out.println("2.Ver todos los productos");
            System.out.println("3.Ver todos los productos inhabilitados");
            System.out.println("4.Editar producto existente");
            System.out.println("5.Buscar producto por ID o nombre");
            System.out.println("6.Eliminar producto");
            System.out.println("7.Salir");
            System.out.println("=========================================");
            System.out.println("Ingrese una opcion: ");
            int opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el id del nuevo producto: ");
                    String id = leer.nextLine();
                    System.out.println("Ingrese el nombre del producto: ");
                    String nombre = leer.nextLine();
                    System.out.println("Ingrese el cuit del proveedor del producto: ");
                    String prov = leer.nextLine();
                    System.out.println("Ingrese la categoria del producto: ");
                    String categ = leer.nextLine();
                    System.out.println("Ingrese la altura del producto: ");
                    float alt = leer.nextFloat();
                    System.out.println("Inrese el ancho del producto: ");
                    float ancho = leer.nextFloat();
                    System.out.println("Inrese la longitud del producto: ");
                    float longi = leer.nextFloat();
                    System.out.println("Ingrese el peso del producto: ");
                    float peso = leer.nextFloat();

                    productoController.create(new Producto(id,proveedorRepository.findOne(prov),new CategoriaProducto(categ),nombre,alt,ancho,longi,peso));
                    break;

                case 2:
                    System.out.println("============== Los productos son: ===============");
                    productoController.findAll();
                    break;

                case 3:
                    System.out.println("============== Los productos son Inhabilitados: ===============");
                    productoController.findAllOff();
                    break;

                case 4:
                    System.out.println("Ingrese el Id del producto a editar: ");
                    String ide = leer.nextLine();
                    System.out.println("Ingrese el nuevo nombre del producto: ");
                    String desc = leer.nextLine();
                    System.out.println("Ingrese el cuit del nuevo proveedor");
                    String cuitprov = leer.nextLine();
                    System.out.println("Ingrese la nueva categoria");
                    String cat = leer.nextLine();
                    System.out.println("Ingrese la nueva altura del producto: ");
                    float altura = leer.nextInt();
                    System.out.println("Ingrese el nuevo grosor del producto: ");
                    float anchor = leer.nextInt();
                    System.out.println("Ingrese la nueva longitud del producto: ");
                    float longitud = leer.nextInt();
                    System.out.println("Ingrese el nuevo peso del producto: ");
                    float pesou = leer.nextInt();

                    productoController.upDate(new Producto(ide,proveedorRepository.findOne(cuitprov),new CategoriaProducto(cat),desc,altura,anchor,longitud,pesou));
                    break;

                case 5:
                    System.out.println("Ingrese el id o nombre del producto buscado: ");
                    String nomId = leer.nextLine();
                    productoController.findOne(nomId);
                    break;

                case 6:
                    System.out.println("Ingrese el Id del producto a eliminar: ");
                    String codid = leer.nextLine();
                    productoController.delete(codid);
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
