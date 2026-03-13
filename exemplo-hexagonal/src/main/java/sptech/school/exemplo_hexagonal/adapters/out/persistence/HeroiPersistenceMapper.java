package sptech.school.exemplo_hexagonal.adapters.out.persistence;

import sptech.school.exemplo_hexagonal.domain.model.Heroi;

// Converte entre entidade de persistencia (JPA) e modelo de dominio.
public final class HeroiPersistenceMapper {

    // Evita instanciacao: classe utilitaria.
    private HeroiPersistenceMapper() {
    }

    // Entidade JPA -> Dominio.
    public static Heroi toDomain(HeroiJpaEntity entity) {
        return new Heroi(
                entity.getId(),
                entity.getNome(),
                entity.getForca(),
                entity.getArma(),
                entity.getTemCapa()
        );
    }

    // Dominio -> Entidade JPA.
    public static HeroiJpaEntity toEntity(Heroi heroi) {
        HeroiJpaEntity entity = new HeroiJpaEntity();
        entity.setId(heroi.getId());
        entity.setNome(heroi.getNome());
        entity.setForca(heroi.getForca());
        entity.setArma(heroi.getArma());
        entity.setTemCapa(heroi.getTemCapa());
        return entity;
    }
}