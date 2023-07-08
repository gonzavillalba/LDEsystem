package org.lde.repository;

import lombok.Getter;
import lombok.Setter;
import org.lde.model.CategoriaProducto;
import org.lde.model.Producto;
import org.lde.model.Proveedor;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public class ProductoRepository implements CRUD<Producto> {
    ProveedorRepository proveedorRepository;
    List<Producto>productos;

    public ProductoRepository() {
        proveedorRepository = new ProveedorRepository();
        productos = new ArrayList<>();
        upLoad();
    }

    @Override
    public void upLoad() {
        CategoriaProducto cp1 = new CategoriaProducto("Informatica");
        CategoriaProducto cp2 = new CategoriaProducto("Vehiculos");
        CategoriaProducto cp3 = new CategoriaProducto("Ropa y Calzados");
        CategoriaProducto cp4 = new CategoriaProducto("Deporte");
        CategoriaProducto cp5 = new CategoriaProducto("Musica");

        Producto producto1 = new Producto("0001",this.proveedorRepository.findOne("0001"),cp1,"Pantalla Led",12F,10F,12F,9F);
        Producto producto2 = new Producto("0002",this.proveedorRepository.findOne("0002"),cp5,"Saxofon",1.2F,0.3F,7F,4F);
        Producto producto3 = new Producto("0003",this.proveedorRepository.findOne("0003"),cp3,"Zapatilla Nike air",2F,3F,4F,1F);
        Producto producto4 = new Producto("0004",this.proveedorRepository.findOne("0004"),cp4,"Raqueta",5F,8F,9F,5F);
        Producto producto5 = new Producto("0005",this.proveedorRepository.findOne("0005"),cp2,"Guardabarro delantero",12F,10F,12F,9F);
        Producto producto6 = new Producto("0006",this.proveedorRepository.findOne("0001"),cp1,"Parlantes",12F,10F,12F,9F);
        Producto producto7 = new Producto("0007",this.proveedorRepository.findOne("0002"),cp5,"Piano",12F,10F,12F,9F);
        Producto producto8 = new Producto("0008",this.proveedorRepository.findOne("0003"),cp3,"Jogger nike",12F,10F,12F,9F);
        Producto producto9 = new Producto("0009",this.proveedorRepository.findOne("0004"),cp3,"Medias adidas",12F,10F,12F,9F);
        Producto producto10 = new Producto("00010",this.proveedorRepository.findOne("0005"),cp2,"Honda Wave S 110cc",12F,10F,12F,9F);
        Producto producto11 = new Producto("00011",this.proveedorRepository.findOne("0001"),cp1,"Ipad",12F,10F,12F,9F);
        Producto producto12 = new Producto("00012",this.proveedorRepository.findOne("0002"),cp2,"Yamaha Cripton 110cc",12F,10F,12F,9F);
        Producto producto13 = new Producto("00013",this.proveedorRepository.findOne("0003"),cp3,"Camiseta nike",12F,10F,12F,9F);
        Producto producto14 = new Producto("00014",this.proveedorRepository.findOne("0004"),cp3,"Campera adidas",12F,10F,12F,9F);
        Producto producto15 = new Producto("00015",this.proveedorRepository.findOne("0005"),cp2,"Honda cb190",12F,10F,12F,9F);

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        productos.add(producto6);
        productos.add(producto7);
        productos.add(producto8);
        productos.add(producto9);
        productos.add(producto10);
        productos.add(producto11);
        productos.add(producto12);
        productos.add(producto13);
        productos.add(producto14);
        productos.add(producto15);
    }

    @Override
    public void save(Producto producto) {
        productos.add(producto);
    }

    @Override
    public void upDate(Producto producto) {
        if (findOne(producto.getIdPreoducto()) != null){
            findOne(producto.getIdPreoducto()).setDescripcion(producto.getDescripcion());
            findOne(producto.getIdPreoducto()).setAltura(producto.getAltura());
            findOne(producto.getIdPreoducto()).setAncho(producto.getAncho());
            findOne(producto.getIdPreoducto()).setPeso(producto.getPeso());
            findOne(producto.getIdPreoducto()).setLongitud(producto.getLongitud());
        }
    }

    @Override
    public List<Producto> findAll() {
        List<Producto>productosHabilitados = new ArrayList<>();
        for (Producto pr : productos){
            if(pr.getEstado().equals(Producto.Estado.Habilitado)){
                productosHabilitados.add(pr);
            }
        }
        return productosHabilitados;
    }

    @Override
    public List<Producto> findAllOff() {
        List<Producto>productosInvalidos = new ArrayList<>();
        for (Producto pr : productos){
            if(pr.getEstado().equals(Producto.Estado.Invalido)){
                productosInvalidos.add(pr);
            }
        }
        return productosInvalidos;
    }

    @Override
    public Producto findOne(String cuit) {
        Producto producto = null;
        for (Producto pr : productos){
            if (pr.getIdPreoducto().equals(cuit) || pr.getDescripcion().equals(cuit)){
                producto = pr;
            }
        }
        return producto;
    }

    @Override
    public void delete(String cuit) {
        for (Producto pr : productos){
            if (findOne(cuit) != null){
                pr.setEstado(Producto.Estado.Invalido);
            }
        }

    }

}
