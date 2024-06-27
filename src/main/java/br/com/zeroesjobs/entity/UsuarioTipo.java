package br.com.zeroesjobs.entity;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario_tipo")
public class UsuarioTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioTipoId;

    private String usuarioTipoNome;

    @OneToMany(targetEntity = Usuario.class, mappedBy = "usuarioTipoId", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

    /*** CONSTRUTOR VAZIO ***/
    public UsuarioTipo() {

    }

    /*** CONSTRUTOR ***/
    public UsuarioTipo(int usuarioTipoId, String usuarioTipoNome, List<Usuario> usuarios) {
        this.usuarioTipoId = usuarioTipoId;
        this.usuarioTipoNome = usuarioTipoNome;
        this.usuarios = usuarios;
    }

    /*** GETTERS / SETTERS ***/
    public int getusuarioTipoId() {
        return usuarioTipoId;
    }

    public void setusuarioTipoId(int usuarioTipoId) {
        this.usuarioTipoId = usuarioTipoId;
    }

    public String getusuarioTipoNome() {
        return usuarioTipoNome;
    }

    public void setusuarioTipoNome(String usuarioTipoNome) {
        this.usuarioTipoNome = usuarioTipoNome;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" +
                "usuarioTipoId=" + usuarioTipoId +
                ", usuarioTipoNome='" + usuarioTipoNome + '\'' +
                ", usuarios=" + usuarios +
                '}';
    }
}
