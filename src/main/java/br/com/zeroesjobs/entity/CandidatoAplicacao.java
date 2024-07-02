package br.com.zeroesjobs.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"usuarioId", "vaga"})
})
public class CandidatoAplicacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarioId", referencedColumnName = "usuario_conta_id")
    private Candidato usuarioId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vaga", referencedColumnName = "vagaId")
    private Vaga vaga;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dataAplicacao;

    private String cartaRecomendacao;

    /*** CONSTRUTOR VAZIO ***/
    public CandidatoAplicacao() {

    }

    /*** CONSTRUTOR PADRÃO ***/
    public CandidatoAplicacao(Integer id, Candidato usuarioId, Vaga vaga, Date dataAplicacao, String cartaRecomendacao) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.vaga = vaga;
        this.dataAplicacao = dataAplicacao;
        this.cartaRecomendacao = cartaRecomendacao;
    }

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

    public Date getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(Date dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getCartaRecomendacao() {
        return cartaRecomendacao;
    }

    public void setCartaRecomendacao(String cartaRecomendacao) {
        this.cartaRecomendacao = cartaRecomendacao;
    }

    @Override
    public String toString() {
        return "CandidatoAplicacao{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", vaga=" + vaga +
                ", dataAplicacao=" + dataAplicacao +
                ", cartaRecomendacao='" + cartaRecomendacao + '\'' +
                '}';
    }
}
