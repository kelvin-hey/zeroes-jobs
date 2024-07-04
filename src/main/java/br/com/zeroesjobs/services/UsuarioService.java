package br.com.zeroesjobs.services;

import br.com.zeroesjobs.controller.UsuarioController;
import br.com.zeroesjobs.entity.Usuario;
import br.com.zeroesjobs.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario addNew(Usuario usuario) {
        usuario.setAtivo(true);
        usuario.setDataCadastro(new Date(System.currentTimeMillis()));
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> getUsuarioEmail(String email) {
        return usuarioRepository.procurarPorEmail(email);
    }
}
