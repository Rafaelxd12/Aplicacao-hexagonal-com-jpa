package sptech.school.exemplo_hexagonal.application.port.in;

import sptech.school.exemplo_hexagonal.domain.model.Heroi;

import java.util.List;
import java.util.Optional;

// Porta de entrada: define o que a aplicacao oferece para adaptadores externos (web, cli etc.).
public interface HeroiUseCase {

    // Lista todos os herois.
    List<Heroi> listar();

    // Cadastra um novo heroi.
    Heroi cadastrar(Heroi heroi);

    // Busca um heroi por id.
    Optional<Heroi> buscarPorId(Integer id);

    // Atualiza um heroi por id.
    Optional<Heroi> atualizar(Integer id, Heroi heroi);

    // Remove um heroi por id.
    boolean deletarPorId(Integer id);

    // Lista herois com forca maior que o valor informado.
    List<Heroi> listarForcaMaior(Integer maior);

    // Busca herois por parte do nome.
    List<Heroi> buscarPorNome(String busca);
}