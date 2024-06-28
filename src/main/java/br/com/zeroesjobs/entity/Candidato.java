package br.com.zeroesjobs.entity;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "candidato")
public class Candidato {

    @Id
    private Integer contaUsuarioId;

    @OneToOne
    @JoinColumn(name = "usuario_conta_id")
    @MapsId
    private Usuario usuarioId;

    /*** DADOS DO CANDIDATO ***/
    private String nome;
    private String sobreNome;
    private String cidade;
    private String estado;
    private String pais;
    private String cpf;
    private String tipoTrabalho;
    private String curriculo;

    @Column(nullable = true, length = 64)
    private String fotoPerfil;

    @OneToMany(targetEntity = Competencias.class, cascade = CascadeType.ALL, mappedBy = "candidato")
    private List<Competencias> competencias;

    /*** CONSTRUTOR VAZIO ***/
    public Candidato() {

    }

    /*** CONSTRUTOR PADRÃO ***/
    public Candidato(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    /*** GETTERS / SETTERS ***/
    public Integer getContaUsuarioId() {
        return contaUsuarioId;
    }

    public void setContaUsuarioId(Integer contaUsuarioId) {
        this.contaUsuarioId = contaUsuarioId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
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
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipoTrabalho() {
        return tipoTrabalho;
    }

    public void setTipoTrabalho(String tipoTrabalho) {
        this.tipoTrabalho = tipoTrabalho;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "contaUsuarioId=" + contaUsuarioId +
                ", usuarioId=" + usuarioId +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                ", cpf='" + cpf + '\'' +
                ", tipoTrabalho='" + tipoTrabalho + '\'' +
                ", curriculo='" + curriculo + '\'' +
                ", fotoPerfil='" + fotoPerfil + '\'' +
                '}';
    }
}
