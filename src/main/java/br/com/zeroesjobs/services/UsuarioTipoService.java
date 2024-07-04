package br.com.zeroesjobs.services;

import br.com.zeroesjobs.entity.UsuarioTipo;
import br.com.zeroesjobs.repository.UsuarioTipoRepository;

import java.util.List;

public class UsuarioTipoService {

    private final UsuarioTipoRepository usuarioTipoRepository;

    public UsuarioTipoService(UsuarioTipoRepository usuarioTipoRepository) {
        this.usuarioTipoRepository = usuarioTipoRepository;
    }

    public List<UsuarioTipo> getAll() {
        return usuarioTipoRepository.findAll();
    }
}
