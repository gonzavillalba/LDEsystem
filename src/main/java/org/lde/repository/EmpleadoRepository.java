package org.lde.repository;

import org.lde.model.Empleado;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepository implements CRUD<Empleado> {
    public List<Empleado>empleados;

    public EmpleadoRepository() {
        this.empleados = new ArrayList<>();
    }

    @Override
    public void upLoad() {
        Empleado e1 = new Empleado("4532","luis","benitez","callefalsa","23423423");
        Empleado e2 = new Empleado("2325","lalo","benitez","callefalsa","23423423");
        Empleado e3 = new Empleado("7465","lelo","benitez","callefalsa","23423423");
        Empleado e4 = new Empleado("9898","lilo","benitez","callefalsa","23423423");


    }

    @Override
    public void save(Empleado empleado) {
        empleados.add(empleado);

    }

    @Override
    public void upDate(Empleado empleado) {
        if (findOne(empleado.getCUIT()) != null){
            findOne(empleado.getCUIT()).setNombre(empleado.getNombre());
            findOne(empleado.getCUIT()).setApellido(empleado.getApellido());
            findOne(empleado.getCUIT()).setDireccion(empleado.getDireccion());
            findOne(empleado.getCUIT()).setTelefono(empleado.getTelefono());
        }


    }

    @Override
    public List<Empleado> findAll() {
        return null;
    }

    @Override
    public List<Empleado> findAllOff() {
        return null;
    }

    @Override
    public Empleado findOne(String cuit) {
        Empleado empleado = null;
        for (Empleado er:empleados){
            if (er.getCUIT().equals(cuit)){
                empleado = er;
            }
        }
        return empleado;
    }

    @Override
    public void delete(String cuit) {

    }
}
