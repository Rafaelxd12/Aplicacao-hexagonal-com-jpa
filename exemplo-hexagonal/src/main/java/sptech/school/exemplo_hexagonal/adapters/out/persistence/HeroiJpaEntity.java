package sptech.school.exemplo_hexagonal.adapters.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// Entidade JPA que representa a tabela Heroi no banco de dados.

@Entity
@Table(name = "Heroi")
public class HeroiJpaEntity {
    // Chave primaria gerada automaticamente pelo banco.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // Colunas mapeadas da tabela.

    private String nome;
    private Integer forca;
    private String arma;
    // Mapeia o nome da coluna no banco (snake_case -> camelCase).

    @Column(name = "tem_capa")
    private Boolean temCapa;

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