package sptech.school.exemplo_hexagonal.adapters.out.persistence;

import org.springframework.stereotype.Component;
import sptech.school.exemplo_hexagonal.application.port.out.HeroiRepositoryPort;
import sptech.school.exemplo_hexagonal.domain.model.Heroi;

import java.util.List;
import java.util.Optional;

// Marca esta classe como componente gerenciado pelo Spring (injetavel em outros pontos da aplicacao).
@Component
// Adapter de saida: implementa a porta de repositorio da aplicacao e conversa com o banco via Spring Data.
public class HeroiPersistenceAdapter implements HeroiRepositoryPort {

    // Repositorio JPA (Spring Data) responsavel por operacoes de persistencia.
    private final SpringDataHeroiRepository repository;

    // Injecao de dependencia do repositorio pelo construtor.
    public HeroiPersistenceAdapter(SpringDataHeroiRepository repository) {
        this.repository = repository;
    }

    @Override
    // Busca todos os registros no banco e converte de entidade JPA para modelo de dominio.
    public List<Heroi> listarTodos() {
        return repository.findAll().stream()
                .map(HeroiPersistenceMapper::toDomain)
                .toList();
    }

    @Override
    // Converte o dominio para entidade, salva no banco e retorna o objeto salvo convertido de volta para dominio.
    public Heroi salvar(Heroi heroi) {
        HeroiJpaEntity salvo = repository.save(HeroiPersistenceMapper.toEntity(heroi));
        return HeroiPersistenceMapper.toDomain(salvo);
    }

    @Override
    // Procura um heroi pelo id; se encontrar, converte para dominio e retorna como Optional.
    public Optional<Heroi> buscarPorId(Integer id) {
        return repository.findById(id)
                .map(HeroiPersistenceMapper::toDomain);
    }

    @Override
    // Verifica se existe um registro com o id informado.
    public boolean existePorId(Integer id) {
        return repository.existsById(id);
    }

    @Override
    // Remove um registro pelo id.
    public void deletarPorId(Integer id) {
        repository.deleteById(id);
    }

    @Override
    // Busca herois com forca maior que o valor informado e converte o resultado para dominio.
    public List<Heroi> buscarPorForcaMaior(Integer maior) {
        return repository.findByForcaGreaterThan(maior).stream()
                .map(HeroiPersistenceMapper::toDomain)
                .toList();
    }

    @Override
    // Busca por nome (contendo texto, sem diferenciar maiusculas/minusculas) e converte para dominio.
    public List<Heroi> buscarPorNome(String busca) {
        return repository.findByNomeContainingIgnoreCase(busca).stream()
                .map(HeroiPersistenceMapper::toDomain)
                .toList();
    }
}