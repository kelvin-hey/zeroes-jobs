package br.com.zeroesjobs.services;

import br.com.zeroesjobs.entity.Recrutador;
import br.com.zeroesjobs.repository.RecrutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecrutadorService {

    private final RecrutadorRepository recrutadorRepository;

    @Autowired
    public RecrutadorService(RecrutadorRepository recrutadorRepository) {
        this.recrutadorRepository = recrutadorRepository;
    }

    public Optional<Recrutador> obter(Integer id) {
        return recrutadorRepository.findById(id);
    }

    public Recrutador adicionar(Recrutador recrutador) {
        return recrutadorRepository.save(recrutador);
    }
}
