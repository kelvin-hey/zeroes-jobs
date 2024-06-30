package br.com.zeroesjobs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String logotipo;

    /*** CONSTRUTOR VAZIO ***/
    public Empresa() {

    }

    /*** CONSTRUTOR PADRÃO ***/
    public Empresa(Integer id, String nome, String logotipo) {
        this.id = id;
        this.nome = nome;
        this.logotipo = logotipo;
    }

    /*** GETTERS / SETTERS ***/
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

    public String getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(String logotipo) {
        this.logotipo = logotipo;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", logotipo='" + logotipo + '\'' +
                '}';
    }
}
