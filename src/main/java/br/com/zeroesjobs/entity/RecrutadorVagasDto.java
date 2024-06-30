package br.com.zeroesjobs.entity;

public class RecrutadorVagasDto {

    private Long totalCandidatos;
    private Integer vagaId;
    private String vagaTitulo;
    private VagaLocalidade vagaLocalidadeId;
    private Empresa empresaId;

    /*** CONSTRUTOR PADRÃO ***/
    public RecrutadorVagasDto(Long totalCandidatos, Integer vagaId, String vagaTitulo, VagaLocalidade vagaLocalidadeId, Empresa VagaEmpresaId) {
        this.totalCandidatos = totalCandidatos;
        this.vagaId = vagaId;
        this.vagaTitulo = vagaTitulo;
        this.vagaLocalidadeId = vagaLocalidadeId;
        this.empresaId = VagaEmpresaId;
    }

    /*** GETTERS / SETTERS ***/
    public Long getTotalCandidatos() {
        return totalCandidatos;
    }

    public void setTotalCandidatos(Long totalCandidatos) {
        this.totalCandidatos = totalCandidatos;
    }

    public Integer getVagaId() {
        return vagaId;
    }

    public void setVagaId(Integer vagaId) {
        this.vagaId = vagaId;
    }

    public String getVagaTitulo() {
        return vagaTitulo;
    }

    public void setVagaTitulo(String vagaTitulo) {
        this.vagaTitulo = vagaTitulo;
    }

    public VagaLocalidade getVagaLocalidadeId() {
        return vagaLocalidadeId;
    }

    public void setVagaLocalidadeId(VagaLocalidade vagaLocalidadeId) {
        this.vagaLocalidadeId = vagaLocalidadeId;
    }

    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa VagaEmpresaId) {
        this.empresaId = VagaEmpresaId;
    }

    @Override
    public String toString() {
        return "RecrutadorVagasDto{" +
                "totalCandidatos=" + totalCandidatos +
                ", vagaId=" + vagaId +
                ", vagaTitulo='" + vagaTitulo + '\'' +
                ", vagaLocalidadeId=" + vagaLocalidadeId +
                ", empresaId=" + empresaId +
                '}';
    }
}
