package sptech.school.exemplo_hexagonal.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repositorio Spring Data com CRUD basico + consultas por convencao de nome.
public interface SpringDataHeroiRepository extends JpaRepository<HeroiJpaEntity, Integer> {

    // Busca herois com forca maior que o parametro.
    List<HeroiJpaEntity> findByForcaGreaterThan(Integer forca);

    // Busca herois cujo nome contenha texto, ignorando maiusculas/minusculas.
    List<HeroiJpaEntity> findByNomeContainingIgnoreCase(String busca);
}