package br.com.zeroesjobs.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recrutador")
public class Recrutador {

    @Id
    private int contaUsuarioId;

    @OneToOne
    @JoinColumn(name = "usuario_conta_id")
    @MapsId
    private Usuario usuarioId;

    @Column(nullable = true, length = 64)
    private String fotoPerfil;

    /*** DADOS DO RECRUTADOR ***/
    private String nome;
    private String sobrenome;
    private String cidade;
    private String estado;
    private String pais;
    private String empresa;

    /*** CONSTRUTOR VAZIO ***/
    public Recrutador() {

    }

    /*** CONSTRUTOR PADRÃO ***/
    public Recrutador(int contaUsuarioId, Usuario usuarioId, String fotoPerfil, String nome, String sobrenome, String cidade, String estado, String pais, String empresa) {
        this.contaUsuarioId = contaUsuarioId;
        this.usuarioId = usuarioId;
        this.fotoPerfil = fotoPerfil;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.empresa = empresa;
    }

    /*** CONSTRUTOR USUÁRIO ***/
    public Recrutador(Usuario usuario) {
        this.usuarioId = usuario;
    }

    /*** GETTERS / SETTERS ***/
    public int getContaUsuarioId() {
        return contaUsuarioId;
    }

    public void setContaUsuarioId(int contaUsuarioId) {
        this.contaUsuarioId = contaUsuarioId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Recrutador{" +
                "contaUsuarioId=" + contaUsuarioId +
                ", usuarioId=" + usuarioId +
                ", fotoPerfil='" + fotoPerfil + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                ", empresa='" + empresa + '\'' +
                '}';
    }
}
