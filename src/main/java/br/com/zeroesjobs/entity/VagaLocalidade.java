package br.com.zeroesjobs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VagaLocalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cidade;
    private String estado;
    private String Pais;

    /*** CONSTRUTOR VAZIO ***/
    public VagaLocalidade() {

    }

    /*** CONSTRUTOR PADRÃO ***/
    public VagaLocalidade(Integer id, String cidade, String estado, String pais) {
        this.id = id;
        this.cidade = cidade;
        this.estado = estado;
        Pais = pais;
    }

    /*** GETTERS / SETTERS ***/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    @Override
    public String toString() {
        return "VagaLocalidade{" +
                "id=" + id +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", Pais='" + Pais + '\'' +
                '}';
    }
}
