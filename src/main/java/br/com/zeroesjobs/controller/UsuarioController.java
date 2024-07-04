package br.com.zeroesjobs.controller;

import br.com.zeroesjobs.entity.Usuario;
import br.com.zeroesjobs.entity.UsuarioTipo;
import br.com.zeroesjobs.services.UsuarioService;
import br.com.zeroesjobs.services.UsuarioTipoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@Controller
public class UsuarioController {

    private final UsuarioTipoService usuarioTipoService;
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioTipoService usuarioTipoService, UsuarioService usuarioService) {
        this.usuarioTipoService = usuarioTipoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        List<UsuarioTipo> usuarioTipo = usuarioTipoService.getAll();
        model.addAttribute("getAllTypes", usuarioTipo);
        model.addAttribute("user", new Usuario());
        return "cadastrar";
    }

    @PostMapping("/cadastrar/novo")
    public String cadastroUsuario(@Valid Usuario usuario, Model model) {
        Optional<Usuario> optionalUsuario = usuarioService.getUsuarioEmail(usuario.getEmail());
        if (optionalUsuario.isPresent()) {
            model.addAttribute("erro", "O email já foi cadastrado");
            List<UsuarioTipo> usuarioTipos = usuarioTipoService.getAll();
            model.addAttribute("obterTodos", usuarioTipos);
            model.addAttribute("usuario", new Usuario());
            return "cadastrar";
        }
        usuarioService.addNew(usuario);
        return "dashboard";
    }
}
