package sptech.school.exemplo_hexagonal.domain.model;

// Entidade de dominio usada no centro da regra de negocio.
public class Heroi {

    // Identificador do heroi (geralmente definido pelo banco).
    private Integer id;
    // Nome do heroi.
    private String nome;
    // Nivel de forca do heroi.
    private Integer forca;
    // Arma principal utilizada.
    private String arma;
    // Indica se o heroi tem capa.
    private Boolean temCapa;

    // Construtor vazio para facilitar serializacao e criacao por frameworks.
    public Heroi() {
    }

    // Construtor usado em cadastros sem id.
    public Heroi(String nome, Integer forca, String arma, Boolean temCapa) {
        this.nome = nome;
        this.forca = forca;
        this.arma = arma;
        this.temCapa = temCapa;
    }

    // Construtor completo, incluindo id (comum em atualizacoes/leitura).
    public Heroi(Integer id, String nome, Integer forca, String arma, Boolean temCapa) {
        this.id = id;
        this.nome = nome;
        this.forca = forca;
        this.arma = arma;
        this.temCapa = temCapa;
    }

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