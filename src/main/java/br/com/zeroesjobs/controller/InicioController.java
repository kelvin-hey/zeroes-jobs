package br.com.zeroesjobs.controller;

import org.springframework.stereotype.Controller;

@Controller
public class InicioController {

    public String inicio() {
        return "index";
    }
}
