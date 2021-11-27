package com.maxi.ProyectoFinalEgg.controladores;


import com.maxi.ProyectoFinalEgg.entidades.Articulo;
import com.maxi.ProyectoFinalEgg.servicios.ArticuloServicio;
import com.maxi.ProyectoFinalEgg.servicios.NotificacionServicio;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private ArticuloServicio articuloServicio;
    
    @Autowired
    private NotificacionServicio notificacionServicio;

    @GetMapping("/")
    public String index(ModelMap modelo) {
        return "index";
    }

    @GetMapping("/login")
    public String login(HttpSession session, Authentication usuario, ModelMap modelo, @RequestParam(required = false) String error,
            @RequestParam(required = false) String logout) {
        try {
            if (usuario.getName() != null) {
                return "redirect:/";
            } else {

                if (error != null && !error.isEmpty()) {
                    modelo.addAttribute("error", "La dirección de mail o la contraseña que ingresó son incorrectas.");
                }
                return "index";
            }
        } catch (Exception e) {
            if (error != null && !error.isEmpty()) {
                modelo.addAttribute("error", "La dirección de mail o la contraseña que ingresó son incorrectas.");
            }
            return "index";
        }
    }

    @GetMapping("/loginsuccess")
    public String loginresolver() {
        return "redirect:/";
    }

    @GetMapping("/catalogo")
    public String catalogo(ModelMap modelo) {
        List<Articulo> articulos = articuloServicio.listarTodos();
        modelo.addAttribute("articulos", articulos);
        return "catalogo";
    }

    @RequestMapping("/nosotros")
    public String Nosotros(ModelMap Modelo) {
        return "nosotros";
    }

    @RequestMapping("/contacto")
    public String Contacto(ModelMap Modelo) {
        return "contacto";
    }

    @PostMapping("/mailsender")
	public String enviarMail(@PathVariable String nombre, @RequestParam String apellido,
                @RequestParam String correo, @RequestParam String mensaje) {
		try {
//			notificacionService.notificar(id, mail);
			return "redirect:/";
		} catch (Exception e) {
			return "redirect:/";
		}
	}

}
