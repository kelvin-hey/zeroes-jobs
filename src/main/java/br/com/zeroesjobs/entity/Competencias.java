package br.com.zeroesjobs.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "competencias")
public class Competencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String nivelExperiencia;
    private String anosExperiencia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidato")
    private Candidato candidato;

    /*** CONSTRUTOR VAZIO ***/
    public Competencias() {

    }

    /*** CONSTRUTOR PADRÃO ***/
    public Competencias(Integer id, String nome, String nivelExperiencia, String anosExperiencia, Candidato candidato) {
        this.id = id;
        this.nome = nome;
        this.nivelExperiencia = nivelExperiencia;
        this.anosExperiencia = anosExperiencia;
        this.candidato = candidato;
    }

    /*** SETTERS / GETTERS ***/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(String nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    public String getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(String anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    @Override
    public String toString() {
        return "Competencias{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nivelExperiencia='" + nivelExperiencia + '\'' +
                ", anosExperiencia='" + anosExperiencia + '\'' +
                ", candidato=" + candidato +
                '}';
    }
}
