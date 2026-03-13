package sptech.school.exemplo_hexagonal.adapters.in.web.dto;

// DTO de entrada da API para criar/atualizar herois.
public class HeroiRequestDto {

    // Campos enviados pelo cliente na requisicao.
    private String nome;
    private Integer forca;
    private String arma;
    private Boolean temCapa;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public Boolean getTemCapa() {
        return temCapa;
    }

    public void setTemCapa(Boolean temCapa) {
        this.temCapa = temCapa;
    }
}