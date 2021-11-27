package com.maxi.ProyectoFinalEgg.controladores;

import com.maxi.ProyectoFinalEgg.entidades.Articulo;
import com.maxi.ProyectoFinalEgg.entidades.Proveedor;
import com.maxi.ProyectoFinalEgg.enumeracion.Rol;
import com.maxi.ProyectoFinalEgg.excepciones.WebException;
import com.maxi.ProyectoFinalEgg.servicios.ArticuloServicio;
import com.maxi.ProyectoFinalEgg.servicios.ProveedorServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/articulo")
public class ArticuloController {

    @Autowired
    private ArticuloServicio articuloServicio;
    @Autowired
    private ProveedorServicio proveedorServicio;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/registro")
    public String articulo(ModelMap Modelo) {
        List<Articulo> articulos = articuloServicio.listarTodos();
        Modelo.addAttribute("articulos", articulos);
        List<Proveedor> proveedores = proveedorServicio.listarTodos();
        Modelo.addAttribute("proveedores", proveedores);
        return "articuloAdmin";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/registro")
    public String guardar(ModelMap modelo, @RequestParam String nombre, @RequestParam Double precio,
            @RequestParam Integer cantidad, @RequestParam String foto, @RequestParam String proveedor, @RequestParam String categoria) {
        try {
            articuloServicio.guardar(nombre, precio, cantidad, foto, proveedor, categoria);
            modelo.put("exito", "registro exitoso");
            return "articuloAdmin";
        } catch (WebException e) {
            modelo.put("error", e.getMessage());
            return "articuloAdmin";
        }
    }

    @PostMapping("/listar")
    public String articulo(ModelMap Modelo, String categoria) {
        List<Articulo> articulos = articuloServicio.BuscarPorCategoria(categoria);
        Modelo.addAttribute("articulos", articulos);
        return "listadoCategorias";
    }

    @PostMapping("/buscar")
    public String Buscar(ModelMap Modelo, String nombre) {
        List<Articulo> articulos = articuloServicio.Buscar(nombre);
        Modelo.addAttribute("articulos", articulos);
        return "listadoCategorias";
    }

}
