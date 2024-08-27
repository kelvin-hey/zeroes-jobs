package br.com.zeroesjobs.controller;

import br.com.zeroesjobs.config.Autenticacao;
import br.com.zeroesjobs.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VagaController {

    private final UsuarioService usuarioService;

    @Autowired
    public VagaController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/dashboard")
    public String procurarVagas(Model model) {

        Object perfilUsuarioAtual = usuarioService.getPerfilUsuarioAtual();
        Authentication autenticacao = SecurityContextHolder.getContext().getAuthentication();

        if(!(autenticacao instanceof AnonymousAuthenticationToken)) {
            String nomeUsuarioAtual = autenticacao.getName();
            model.addAttribute("nomeUsuario", nomeUsuarioAtual);
        }

        model.addAttribute("usuario", perfilUsuarioAtual);

        return "dashboard";
    }
}