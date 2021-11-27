package com.maxi.ProyectoFinalEgg.servicios;

import com.maxi.ProyectoFinalEgg.entidades.Articulo;
import com.maxi.ProyectoFinalEgg.entidades.Proveedor;
import com.maxi.ProyectoFinalEgg.excepciones.WebException;
import com.maxi.ProyectoFinalEgg.repositorios.ProveedorRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProveedorServicio {

    @Autowired
    private ProveedorRepositorio proveedorRepositorio;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {WebException.class, Exception.class})
    public Proveedor guardar(Proveedor proveedor) throws WebException {

//        validar(nombre, precio, cantidad, foto, proveedor);
        Proveedor entidad = new Proveedor();
        entidad.setNombre(proveedor.getNombre());
        entidad.setCorreo(proveedor.getCorreo());
        entidad.setAlta(true);
        return proveedorRepositorio.save(entidad);
    }

    @Transactional(readOnly = true)
    public List<Proveedor> listarTodos() {
        return proveedorRepositorio.findAllByOrderByNombreAsc();
    }

}
