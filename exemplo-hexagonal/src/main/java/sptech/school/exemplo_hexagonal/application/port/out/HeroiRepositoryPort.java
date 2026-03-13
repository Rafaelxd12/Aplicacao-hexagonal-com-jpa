package sptech.school.exemplo_hexagonal.application.port.out;

import sptech.school.exemplo_hexagonal.domain.model.Heroi;

import java.util.List;
import java.util.Optional;

// Porta de saida: contrato que a infraestrutura deve implementar para persistir dados.
public interface HeroiRepositoryPort {

    // Retorna todos os herois persistidos.
    List<Heroi> listarTodos();

    // Persiste um heroi (insert/update) e retorna o estado salvo.
    Heroi salvar(Heroi heroi);

    // Busca um heroi por id.
    Optional<Heroi> buscarPorId(Integer id);

    // Informa se existe heroi com o id informado.
    boolean existePorId(Integer id);

    // Deleta um heroi por id.
    void deletarPorId(Integer id);

    // Busca herois com forca maior que o parametro.
    List<Heroi> buscarPorForcaMaior(Integer maior);

    // Busca herois por parte do nome (filtro textual).
    List<Heroi> buscarPorNome(String busca);
}