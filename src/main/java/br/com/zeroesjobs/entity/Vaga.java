package br.com.zeroesjobs.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vagaId;

    @ManyToOne
    @JoinColumn(name = "anunciante_id", referencedColumnName = "usuario_id")
    private Usuario anuncianteId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vaga_localidade_id", referencedColumnName = "id")
    private VagaLocalidade vagaLocalidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    private Empresa vagaEmpresa;

    @Transient
    private boolean estaAtiva;

    @Transient
    private boolean estaSalva;

    @Length(max = 10000)
    private String descricao;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dataPublicada;

    private String tituloVaga;
    private String tipoVaga;
    private String salario;
    private String remota;

    /*** CONSTRUTOR VAZIO ***/
    public Vaga() {

    }

    /*** CONSTRUTOR PADRÃO ***/
    public Vaga(Integer vagaId, Usuario anuncianteId, VagaLocalidade vagaLocalidade, Empresa vagaEmpresa, boolean estaAtiva, boolean estaSalva, String descricao, Date dataPublicada, String tituloVaga, String tipoVaga, String salario, String remota) {
        this.vagaId = vagaId;
        this.anuncianteId = anuncianteId;
        this.vagaLocalidade = vagaLocalidade;
        this.vagaEmpresa = vagaEmpresa;
        this.estaAtiva = estaAtiva;
        this.estaSalva = estaSalva;
        this.descricao = descricao;
        this.dataPublicada = dataPublicada;
        this.tituloVaga = tituloVaga;
        this.tipoVaga = tipoVaga;
        this.salario = salario;
        this.remota = remota;
    }

    /*** GETTERS / SETTERS ***/
    public Integer getVagaId() {
        return vagaId;
    }

    public void setVagaId(Integer vagaId) {
        this.vagaId = vagaId;
    }

    public Usuario getAnuncianteId() {
        return anuncianteId;
    }

    public void setAnuncianteId(Usuario anuncianteId) {
        this.anuncianteId = anuncianteId;
    }

    public VagaLocalidade getVagaLocalidade() {
        return vagaLocalidade;
    }

    public void setVagaLocalidade(VagaLocalidade vagaLocalidade) {
        this.vagaLocalidade = vagaLocalidade;
    }

    public Empresa getVagaEmpresa() {
        return vagaEmpresa;
    }

    public void setVagaEmpresa(Empresa vagaEmpresa) {
        this.vagaEmpresa = vagaEmpresa;
    }

    public boolean isEstaAtiva() {
        return estaAtiva;
    }

    public void setEstaAtiva(boolean estaAtiva) {
        this.estaAtiva = estaAtiva;
    }

    public boolean isEstaSalva() {
        return estaSalva;
    }

    public void setEstaSalva(boolean estaSalva) {
        this.estaSalva = estaSalva;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataPublicada() {
        return dataPublicada;
    }

    public void setDataPublicada(Date dataPublicada) {
        this.dataPublicada = dataPublicada;
    }

    public String getTituloVaga() {
        return tituloVaga;
    }

    public void setTituloVaga(String tituloVaga) {
        this.tituloVaga = tituloVaga;
    }

    public String getTipoVaga() {
        return tipoVaga;
    }

    public void setTipoVaga(String tipoVaga) {
        this.tipoVaga = tipoVaga;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getRemota() {
        return remota;
    }

    public void setRemota(String remota) {
        this.remota = remota;
    }

    @Override
    public String toString() {
        return "Vaga{" +
                "vagaId=" + vagaId +
                ", anuncianteId=" + anuncianteId +
                ", vagaLocalidade=" + vagaLocalidade +
                ", vagaEmpresa=" + vagaEmpresa +
                ", estaAtiva=" + estaAtiva +
                ", estaSalva=" + estaSalva +
                ", descricao='" + descricao + '\'' +
                ", dataPublicada=" + dataPublicada +
                ", tituloVaga='" + tituloVaga + '\'' +
                ", tipoVaga='" + tipoVaga + '\'' +
                ", salario='" + salario + '\'' +
                ", remota='" + remota + '\'' +
                '}';
    }
}
