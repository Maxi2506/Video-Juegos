package com.maxi.ProyectoFinalEgg.controladores;

import com.maxi.ProyectoFinalEgg.entidades.Articulo;
import com.maxi.ProyectoFinalEgg.excepciones.WebException;
import com.maxi.ProyectoFinalEgg.servicios.CarritoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/carrito")
public class CarritoController {
    
    @Autowired
    private CarritoServicio carritoServicio;
    
    @GetMapping("/carrito")
    public String carrito(ModelMap Modelo) {
        return "listado-carrito";
    }

    @PostMapping("/registro")
    public String guardar(ModelMap modelo, @RequestParam String usuario,
            @RequestParam List<Articulo> articulos, @RequestParam Double total) {
        try {
            carritoServicio.guardar(usuario, articulos, total);
            modelo.put("exito", "registro exitoso");
            return "listado-carrito";
        } catch (WebException e){
            modelo.put("error", e.getMessage());
            return "listado-carrito";
        }
    }
}
