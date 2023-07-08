package org.lde.repository;

import lombok.Getter;
import lombok.Setter;
import org.lde.model.Sector;
import org.lde.model.Sucursal;
import org.lde.model.Ubicacion;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public class SucursalRepository implements CRUD<Sucursal> {
    public List<Sucursal>sucursales;
    SectorRepository sectorRepository = new SectorRepository();

    public SucursalRepository() {
        this.sucursales = new ArrayList<>();
        upLoad();
    }

    @Override
    public void upLoad() {

        Sucursal s1 = new Sucursal("0001","LDE Posadas","Costanera","1111","ldepos@gmail",new Ubicacion(100F,200F));
        Sucursal s2 = new Sucursal("0002","LDE Corrientes","calle1","2222","ldecorr@gmail",new Ubicacion(200F,300F));
        Sucursal s3 = new Sucursal("0003","LDE Resistencia","calle2","3333","lderes@gmail",new Ubicacion(300F,400F));
        Sucursal s4 = new Sucursal("0004","LDE Ushuaia","calle3","4444","ldeush@gmail",new Ubicacion(400F,500F));
        Sucursal s5 = new Sucursal("0005","LDE CABA","calle4","5555","ldecaba@gmail",new Ubicacion(500F,600F));
        Sucursal s6 = new Sucursal("0006","LDE Pampa","calle5","6666","ldepam@gmail",new Ubicacion(600F,700F));
        Sucursal s7 = new Sucursal("0007","LDE Santa Fe","calle6","7777","ldesf@gmail",new Ubicacion(700F,800F));
        Sucursal s8 = new Sucursal("0008","LDE Rosario","calle7","8888","lderos@gmail",new Ubicacion(800F,900F));
        Sucursal s9 = new Sucursal("0009","LDE Bariloche","calle8","9999","ldebar@gmail",new Ubicacion(900F,150F));
        Sucursal s10 = new Sucursal("0010","LDE Iguazu","calle9","1010","ldeizu@gmail",new Ubicacion(150F,250F));
        Sucursal s11 = new Sucursal("0011","LDE Cordoba","calle10","1100","ldecord@gmail",new Ubicacion(250F,350F));
        Sucursal s12 = new Sucursal("0012","LDE Mendoza","calle11","1200","ldemend@gmail",new Ubicacion(350F,450F));
        Sucursal s13 = new Sucursal("0013","LDE La Plata","calle12","1300","ldelp@gmail",new Ubicacion(450F,550F));
        Sucursal s14 = new Sucursal("0014","LDE Rawson","calle13","1400","lderaw@gmail",new Ubicacion(550F,650F));
        Sucursal s15 = new Sucursal("0015","LDE San Salvador","calle14","1500","ldess@gmail",new Ubicacion(650F,750F));

        s1.setSectores(sectorRepository.getSectores());
        s2.setSectores(sectorRepository.getSectores());
        s3.setSectores(sectorRepository.getSectores());
        s4.setSectores(sectorRepository.getSectores());
        s5.setSectores(sectorRepository.getSectores());
        s6.setSectores(sectorRepository.getSectores());
        s7.setSectores(sectorRepository.getSectores());
        s8.setSectores(sectorRepository.getSectores());
        s9.setSectores(sectorRepository.getSectores());
        s10.setSectores(sectorRepository.getSectores());
        s11.setSectores(sectorRepository.getSectores());
        s12.setSectores(sectorRepository.getSectores());
        s13.setSectores(sectorRepository.getSectores());
        s14.setSectores(sectorRepository.getSectores());
        s15.setSectores(sectorRepository.getSectores());

        sucursales.add(s1);
        sucursales.add(s2);
        sucursales.add(s3);
        sucursales.add(s4);
        sucursales.add(s5);
        sucursales.add(s6);
        sucursales.add(s7);
        sucursales.add(s8);
        sucursales.add(s9);
        sucursales.add(s10);
        sucursales.add(s11);
        sucursales.add(s12);
        sucursales.add(s13);
        sucursales.add(s14);
        sucursales.add(s15);
    }

    @Override
    public void save(Sucursal sucursal) {
        sucursales.add(sucursal);

    }

    @Override
    public void upDate(Sucursal sucursal) {
            if (findOne(sucursal.getCodSucursal()) != null){
                findOne(sucursal.getCodSucursal()).setNombre(sucursal.getNombre());
                findOne(sucursal.getCodSucursal()).setDireccion(sucursal.getDireccion());
                findOne(sucursal.getCodSucursal()).setEmail(sucursal.getEmail());
                findOne(sucursal.getCodSucursal()).setTelefono(sucursal.getTelefono());
                findOne(sucursal.getCodSucursal()).setUbicacion(sucursal.getUbicacion());
            }
    }

    @Override
    public List<Sucursal> findAll() {
        List<Sucursal>sucursalesHabilitadas = new ArrayList<>();
        for (Sucursal sr : sucursales){
            if(sr.getEstado() == Sucursal.Estado.Habilitado){
                sucursalesHabilitadas.add(sr);
            }
        }
        return sucursalesHabilitadas;
    }

    @Override
    public List<Sucursal> findAllOff() {
        List<Sucursal>sucursalesInhabilitadas = new ArrayList<>();
        for (Sucursal sr : sucursales){
            if(sr.getEstado() == Sucursal.Estado.Invalido){
                sucursalesInhabilitadas.add(sr);
            }
        }
        return sucursalesInhabilitadas;
    }

    @Override
    public Sucursal findOne(String cuit) {
        Sucursal sucursal = null;
        for (Sucursal sr : sucursales){
            if (sr.getCodSucursal().equals(cuit)||sr.getNombre().equals(cuit)){
                sucursal = sr;
            }
        }
        return sucursal;
    }

    @Override
    public void delete(String cuit) {
            if (findOne(cuit) != null){
                findOne(cuit).setEstado(Sucursal.Estado.Invalido);
            }
    }
}
