package sptech.school.exemplo_hexagonal.application.service;

import org.springframework.stereotype.Service;
import sptech.school.exemplo_hexagonal.application.port.in.HeroiUseCase;
import sptech.school.exemplo_hexagonal.application.port.out.HeroiRepositoryPort;
import sptech.school.exemplo_hexagonal.domain.model.Heroi;

import java.util.List;
import java.util.Optional;

// Camada de aplicacao: implementa os casos de uso e orquestra regras.
@Service
public class HeroiService implements HeroiUseCase {

    // Porta de saida para persistencia (inversao de dependencia da arquitetura hexagonal).
    private final HeroiRepositoryPort repositoryPort;

    // Injecao da implementacao da porta de repositorio.
    public HeroiService(HeroiRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    // Lista todos os herois via repositorio.
    public List<Heroi> listar() {
        return repositoryPort.listarTodos();
    }

    @Override
    // Cadastra um novo heroi.
    public Heroi cadastrar(Heroi heroi) {
        return repositoryPort.salvar(heroi);
    }

    @Override
    // Busca um heroi pelo id.
    public Optional<Heroi> buscarPorId(Integer id) {
        return repositoryPort.buscarPorId(id);
    }

    @Override
    // Atualiza um heroi apenas se ele ja existir.
    public Optional<Heroi> atualizar(Integer id, Heroi heroi) {
        if (!repositoryPort.existePorId(id)) {
            return Optional.empty();
        }

        // Garante que o id atualizado seja o da URL, nao o recebido no corpo.
        return Optional.of(repositoryPort.salvar(new Heroi(
                id,
                heroi.getNome(),
                heroi.getForca(),
                heroi.getArma(),
                heroi.getTemCapa()
        )));
    }

    @Override
    // Deleta por id e informa se o registro existia.
    public boolean deletarPorId(Integer id) {
        if (!repositoryPort.existePorId(id)) {
            return false;
        }

        repositoryPort.deletarPorId(id);
        return true;
    }

    @Override
    // Lista herois com forca acima de um valor.
    public List<Heroi> listarForcaMaior(Integer maior) {
        return repositoryPort.buscarPorForcaMaior(maior);
    }

    @Override
    // Filtra herois por trecho do nome.
    public List<Heroi> buscarPorNome(String busca) {
        return repositoryPort.buscarPorNome(busca);
    }
}