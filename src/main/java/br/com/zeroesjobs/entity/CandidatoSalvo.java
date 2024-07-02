package br.com.zeroesjobs.entity;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"usuarioId", "vaga"})})
public class CandidatoSalvo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarioId", referencedColumnName = "usuario_conta_id")
    private Candidato usuarioId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vaga", referencedColumnName = "VagaId")
    private Vaga vaga;

    /*** CONSTRUTOR VAZIO ***/
    public CandidatoSalvo() {

    }

    /*** CONSTRUTOR PADRÃO ***/
    public CandidatoSalvo(Integer id, Candidato usuarioId, Vaga vaga) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.vaga = vaga;
    }

    /*** GETTERS / SETTERS ***/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Candidato getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Candidato usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    @Override
    public String toString() {
        return "CandidatoSalvo{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", vaga=" + vaga +
                '}';
    }
}
