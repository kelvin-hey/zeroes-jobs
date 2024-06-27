package br.com.zeroesjobs.entity;

import java.util.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(unique = true)
    private String email;

    @NotEmpty
    private String senha;

    private boolean ativo;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dataCadastro;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarioTipoId", referencedColumnName = "usuario_tipo_id")
    private UsuarioTipo usuarioTipoId;

    /*** CONSTRUTOR VAZIO ***/
    public Usuario() {

    }

    /*** CONSTRUTOR ***/
    public Usuario(int idUsuario, String email, String senha, boolean ativo, Date dataCadastro) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
    }

    /*** GETTERS / SETTERS ***/
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", ativo=" + ativo +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
