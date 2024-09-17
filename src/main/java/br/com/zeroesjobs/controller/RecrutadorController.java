package br.com.zeroesjobs.controller;

import br.com.zeroesjobs.entity.Recrutador;
import br.com.zeroesjobs.entity.Usuario;
import br.com.zeroesjobs.repository.RecrutadorRepository;
import br.com.zeroesjobs.repository.UsuarioRepository;
import br.com.zeroesjobs.services.RecrutadorService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/recrutador")
public class RecrutadorController {

    private final UsuarioRepository usuarioRepository;
    private final RecrutadorService recrutadorService;

    public RecrutadorController(UsuarioRepository usuarioRepository, RecrutadorService recrutadorService) {
        this.usuarioRepository = usuarioRepository;
        this.recrutadorService = recrutadorService;
    }

    @GetMapping("/")
    public String Recrutador(Model model) {

        Authentication autenticacao = SecurityContextHolder.getContext().getAuthentication();

        if (!(autenticacao instanceof AnonymousAuthenticationToken)) {
            String nome = autenticacao.getName();
            Usuario usuario = usuarioRepository.findByEmail(nome).orElseThrow(
                    () -> new UsernameNotFoundException("Não foi possível encontrar o usuário")
            );
            Optional<Recrutador> recrutador = recrutadorService.obter(usuario.getUsuarioId());

            if (!recrutador.isEmpty()) {
                model.addAttribute("recrutador", recrutador.get());
            }
        }

        return "recrutador";
    }
}
