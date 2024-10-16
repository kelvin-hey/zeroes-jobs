package br.com.zeroesjobs.controller;

import br.com.zeroesjobs.config.Autenticacao;
import br.com.zeroesjobs.entity.Usuario;
import br.com.zeroesjobs.entity.UsuarioTipo;
import br.com.zeroesjobs.services.UsuarioService;
import br.com.zeroesjobs.services.UsuarioTipoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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

    @Autowired
    public UsuarioController(UsuarioTipoService usuarioTipoService, UsuarioService usuarioService) {
        this.usuarioTipoService = usuarioTipoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        List<UsuarioTipo> usuarioTipo = usuarioTipoService.getAll();
        model.addAttribute("getTipoUsuario", usuarioTipo);
        model.addAttribute("usuario", new Usuario());
        return "cadastrar";
    }

    @PostMapping("/cadastrar/novo")
    public String cadastroUsuario(@Valid Usuario usuario, Model model) {
        Optional<Usuario> optionalUsuario = usuarioService.getUsuarioEmail(usuario.getEmail());
        if (optionalUsuario.isPresent()) {
            model.addAttribute("erro", "O email já foi cadastrado");
            List<UsuarioTipo> usuarioTipo = usuarioTipoService.getAll();
            model.addAttribute("obterTodos", usuarioTipo);
            model.addAttribute("usuario", new Usuario());
            return "cadastrar";
        }

        usuarioService.adicionar(usuario);
        return "dashboard";
    }

    @PostMapping("/cadastrar/novo")
    public String cadastroUsuario(@Valid Usuario usuario) {
        usuarioService.adicionar(usuario);
        return "redirect:/dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication autenticacao = SecurityContextHolder.getContext().getAuthentication();

        if (autenticacao != null) {
            new SecurityContextLogoutHandler().logout(request, response, autenticacao);
        }

        return "redirect:/";
    }
}
