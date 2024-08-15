package br.com.zeroesjobs.repository;

import br.com.zeroesjobs.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {
}
