package br.com.zeroesjobs.services;

import br.com.zeroesjobs.controller.UsuarioController;
import br.com.zeroesjobs.entity.Candidato;
import br.com.zeroesjobs.entity.Recrutador;
import br.com.zeroesjobs.entity.Usuario;
import br.com.zeroesjobs.repository.CandidatoRepository;
import br.com.zeroesjobs.repository.RecrutadorRepository;
import br.com.zeroesjobs.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final CandidatoRepository candidatoRepository;
    private final RecrutadorRepository recrutadorRepository;
    private final PasswordEncoder codificadorDeSenhas;

    // Construtor padrão
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, CandidatoRepository candidatoRepository, RecrutadorRepository recrutadorRepository, PasswordEncoder codificadorDeSenhas) {
        this.usuarioRepository = usuarioRepository;
        this.candidatoRepository = candidatoRepository;
        this.recrutadorRepository = recrutadorRepository;
        this.codificadorDeSenhas = codificadorDeSenhas;
    }

    public Usuario adicionar(Usuario usuario) {
        usuario.setAtivo(true);
        usuario.setDataCadastro(new Date(System.currentTimeMillis()));
        usuario.setSenha(codificadorDeSenhas.encode(usuario.getSenha()));

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        int usuarioTipoId = usuario.getUsuarioId();

        if (usuarioTipoId == 1) {
            recrutadorRepository.save(new Recrutador(usuarioSalvo));
        } else {
            candidatoRepository.save(new Candidato(usuarioSalvo));
        }

        return usuarioSalvo;
    }

    public Optional<Usuario> getUsuarioEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
