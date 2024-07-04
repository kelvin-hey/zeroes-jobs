package br.com.zeroesjobs.controller;

import br.com.zeroesjobs.entity.Usuario;
import br.com.zeroesjobs.entity.UsuarioTipo;
import br.com.zeroesjobs.services.UsuarioTipoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsuarioController {

    private final UsuarioTipoService usuarioTipoService;

    public UsuarioController(UsuarioTipoService usuarioTipoService) {
        this.usuarioTipoService = usuarioTipoService;
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        List<UsuarioTipo> usuarioTipo = usuarioTipoService.getAll();
        model.addAttribute("getAllTypes", usuarioTipo);
        model.addAttribute("user", new Usuario());
        return "register";
    }
}
