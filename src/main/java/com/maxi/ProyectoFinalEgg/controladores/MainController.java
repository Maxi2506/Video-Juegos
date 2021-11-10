package com.maxi.ProyectoFinalEgg.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String index(ModelMap modelo) {

        return "index";
    }

    @GetMapping("/login")
    public String login(ModelMap modelo) {

        return "login";
    }

}
