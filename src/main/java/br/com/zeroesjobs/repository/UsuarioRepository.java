package br.com.zeroesjobs.repository;

import br.com.zeroesjobs.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
