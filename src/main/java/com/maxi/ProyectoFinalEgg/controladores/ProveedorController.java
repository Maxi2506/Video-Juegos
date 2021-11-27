package com.maxi.ProyectoFinalEgg.controladores;

import com.maxi.ProyectoFinalEgg.entidades.Proveedor;
import com.maxi.ProyectoFinalEgg.excepciones.WebException;
import com.maxi.ProyectoFinalEgg.servicios.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorServicio proveedorServicio;
 
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/registro")
    public String proveedor(ModelMap Modelo, final Proveedor proveedor) {
        return "proveedorAdmin";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/registro")
    public String guardar(ModelMap modelo, Proveedor proveedor) {
        try {
            proveedorServicio.guardar(proveedor);
            modelo.put("exito", "registro exitoso");
            return "redirect:/proveedor/registro";
        } catch (WebException e) {
            modelo.put("error", e.getMessage());
            return "proveedorAdmin";
        }
    }
}
