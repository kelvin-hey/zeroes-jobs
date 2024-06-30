package br.com.zeroesjobs.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"usuario_id", "vaga"})
})
public class CandidatoAplicacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_conta_id")
    private Candidato usuario_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vaga", referencedColumnName = "vaga_postada_id")
    private VagaAtividade vaga;
}
