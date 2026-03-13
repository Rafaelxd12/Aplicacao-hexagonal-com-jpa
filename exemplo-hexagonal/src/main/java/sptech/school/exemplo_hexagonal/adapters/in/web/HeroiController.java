package sptech.school.exemplo_hexagonal.adapters.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sptech.school.exemplo_hexagonal.adapters.in.web.dto.HeroiRequestDto;
import sptech.school.exemplo_hexagonal.adapters.in.web.dto.HeroiResponseDto;
import sptech.school.exemplo_hexagonal.application.port.in.HeroiUseCase;

import java.util.List;

// Adapter de entrada HTTP: traduz requisicoes REST para casos de uso.
@RestController
@RequestMapping("/herois")
public class HeroiController {

    // Porta de entrada da aplicacao com as regras de negocio.
    private final HeroiUseCase heroiUseCase;

    // Injecao do caso de uso via construtor.
    public HeroiController(HeroiUseCase heroiUseCase) {
        this.heroiUseCase = heroiUseCase;
    }

    @GetMapping
    // GET /herois: lista todos os herois.
    public ResponseEntity<List<HeroiResponseDto>> listar() {
        List<HeroiResponseDto> todosHerois = heroiUseCase.listar().stream()
                .map(HeroiWebMapper::toResponse)
                .toList();

        if (todosHerois.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(todosHerois);
    }

    @PostMapping
    // POST /herois: cadastra um novo heroi.
    public ResponseEntity<HeroiResponseDto> cadastrar(@RequestBody HeroiRequestDto heroiDto) {
        HeroiResponseDto heroiRegistrado = HeroiWebMapper.toResponse(
                heroiUseCase.cadastrar(HeroiWebMapper.toDomain(heroiDto))
        );

        return ResponseEntity.status(201).body(heroiRegistrado);
    }

    @GetMapping("/{id}")
    // GET /herois/{id}: busca por id.
    public ResponseEntity<HeroiResponseDto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.of(
                heroiUseCase.buscarPorId(id)
                        .map(HeroiWebMapper::toResponse)
        );
    }

    @PutMapping("/{id}")
    // PUT /herois/{id}: atualiza dados do heroi.
    public ResponseEntity<HeroiResponseDto> atualizarPorId(
            @PathVariable Integer id,
            @RequestBody HeroiRequestDto heroiParaAtualizarDto
    ) {
        return ResponseEntity.of(
                heroiUseCase.atualizar(id, HeroiWebMapper.toDomain(id, heroiParaAtualizarDto))
                        .map(HeroiWebMapper::toResponse)
        );
    }

    @DeleteMapping("/{id}")
    // DELETE /herois/{id}: remove o heroi se existir.
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        if (!heroiUseCase.deletarPorId(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/forca")
    // GET /herois/forca?maior=X: filtra por forca maior que X.
    public ResponseEntity<List<HeroiResponseDto>> listarForcaMaior(@RequestParam Integer maior) {
        List<HeroiResponseDto> listaFiltrada = heroiUseCase.listarForcaMaior(maior).stream()
                .map(HeroiWebMapper::toResponse)
                .toList();

        if (listaFiltrada.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listaFiltrada);
    }

    @GetMapping("/filtro")
    // GET /herois/filtro?busca=texto: filtra por nome contendo texto.
    public ResponseEntity<List<HeroiResponseDto>> buscarPorNome(@RequestParam String busca) {
        List<HeroiResponseDto> listaFiltrada = heroiUseCase.buscarPorNome(busca).stream()
                .map(HeroiWebMapper::toResponse)
                .toList();

        if (listaFiltrada.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listaFiltrada);
    }
}