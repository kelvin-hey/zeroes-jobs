package br.com.zeroesjobs.services;

import br.com.zeroesjobs.entity.Usuario;
import br.com.zeroesjobs.repository.UsuarioRepository;
import br.com.zeroesjobs.util.DadosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DadosUsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public DadosUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        return new DadosUsuario(usuario); 
    }
}
