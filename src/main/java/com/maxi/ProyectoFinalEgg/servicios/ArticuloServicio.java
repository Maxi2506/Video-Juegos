package com.maxi.ProyectoFinalEgg.servicios;

import com.maxi.ProyectoFinalEgg.entidades.Articulo;
import com.maxi.ProyectoFinalEgg.enumeracion.Categoria;
import com.maxi.ProyectoFinalEgg.excepciones.WebException;
import com.maxi.ProyectoFinalEgg.repositorios.ArticuloRepositorio;
import com.maxi.ProyectoFinalEgg.repositorios.ProveedorRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServicio {

    @Autowired
    private ArticuloRepositorio articuloRepositorio;

    @Autowired
    private ProveedorRepositorio proveedorRepositorio;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {WebException.class, Exception.class})
    public Articulo guardar(String nombre, Double precio, Integer cantidad,
            String foto, String proveedor, String categoria) throws WebException {

//        validar(nombre, precio, cantidad, foto, proveedor);
        Articulo entidad = new Articulo();
        entidad.setNombre(nombre);
        entidad.setPrecio(precio);
        entidad.setCantidad(cantidad);
        entidad.setFoto(foto);
        entidad.setAlta(true);
        entidad.setCategoria(Categoria.valueOf(categoria));
        entidad.setProveedor(proveedorRepositorio.getById(proveedor));
        return articuloRepositorio.save(entidad);
    }

    @Transactional(readOnly = true)
    public List<Articulo> listarTodos() {
        return articuloRepositorio.findAllByOrderByNombreAsc();
    }

    @Transactional(readOnly = true)
    public List<Articulo> BuscarPorCategoria(String categoria) {
        return articuloRepositorio.buscarPorCategoria(Categoria.valueOf(categoria));
    }

    @Transactional(readOnly = true)
    public List<Articulo> Buscar(String nombre) {
        return articuloRepositorio.findByNombreContainingOrderByNombre(nombre);
    }
    
}
