package com.maxi.ProyectoFinalEgg.servicios;

import com.maxi.ProyectoFinalEgg.entidades.Articulo;
import com.maxi.ProyectoFinalEgg.entidades.Carrito;
import com.maxi.ProyectoFinalEgg.excepciones.WebException;
import com.maxi.ProyectoFinalEgg.repositorios.CarritoRepositorio;
import com.maxi.ProyectoFinalEgg.repositorios.UsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarritoServicio {

    @Autowired
    private CarritoRepositorio carritoRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {WebException.class, Exception.class})
    public Carrito guardar(String usuario, List<Articulo> articulos, Double total) throws WebException {

//        validar(nombre, precio, cantidad, foto, proveedor);
        Carrito entidad = new Carrito();

        entidad.setUsuario(usuarioRepositorio.getById(usuario));
        entidad.setArticulos(articulos);
        entidad.setTotal(total);

        return carritoRepositorio.save(entidad);
    }
}
