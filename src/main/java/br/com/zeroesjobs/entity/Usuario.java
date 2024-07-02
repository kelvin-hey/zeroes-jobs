package br.com.zeroesjobs.entity;

import java.util.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioId;

    @Column(unique = true)
    private String email;

    @NotEmpty
    private String senha;

    private boolean ativo;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dataCadastro;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarioTipoId", referencedColumnName = "usuarioTipoId")
    private UsuarioTipo usuarioTipoId;

    /*** CONSTRUTOR VAZIO ***/
    public Usuario() {

    }

    /*** CONSTRUTOR ***/
    public Usuario(int usuarioId, String email, String senha, boolean ativo, Date dataCadastro, UsuarioTipo usuarioTipoId) {
        this.usuarioId = usuarioId;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
        this.usuarioTipoId = usuarioTipoId;
    }

    /*** GETTERS / SETTERS ***/
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public UsuarioTipo getUsuarioTipoId() {
        return usuarioTipoId;
    }

    public void setUsuarioTipoId(UsuarioTipo usuarioTipoId) {
        this.usuarioTipoId = usuarioTipoId;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuarioId=" + usuarioId +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", ativo=" + ativo +
                ", dataCadastro=" + dataCadastro +
                ", usuarioTipoId=" + usuarioTipoId +
                '}';
    }
}
