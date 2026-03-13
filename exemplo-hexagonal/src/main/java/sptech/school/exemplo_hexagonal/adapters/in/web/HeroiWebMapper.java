package sptech.school.exemplo_hexagonal.adapters.in.web;

import sptech.school.exemplo_hexagonal.adapters.in.web.dto.HeroiRequestDto;
import sptech.school.exemplo_hexagonal.adapters.in.web.dto.HeroiResponseDto;
import sptech.school.exemplo_hexagonal.domain.model.Heroi;

// Classe utilitaria para converter entre DTOs da API e modelo de dominio.
public final class HeroiWebMapper {

    // Evita instanciacao: somente metodos estaticos.
    private HeroiWebMapper() {
    }

    // Converte DTO de requisicao para modelo de dominio (sem id).
    public static Heroi toDomain(HeroiRequestDto dto) {
        return new Heroi(
                dto.getNome(),
                dto.getForca(),
                dto.getArma(),
                dto.getTemCapa()
        );
    }

    // Converte DTO de requisicao para dominio incluindo id (usado em atualizacao).
    public static Heroi toDomain(Integer id, HeroiRequestDto dto) {
        return new Heroi(
                id,
                dto.getNome(),
                dto.getForca(),
                dto.getArma(),
                dto.getTemCapa()
        );
    }

    // Converte modelo de dominio para DTO de resposta da API.
    public static HeroiResponseDto toResponse(Heroi heroi) {
        HeroiResponseDto dto = new HeroiResponseDto();
        dto.setId(heroi.getId());
        dto.setNome(heroi.getNome());
        dto.setForca(heroi.getForca());
        dto.setArma(heroi.getArma());
        dto.setTemCapa(heroi.getTemCapa());
        return dto;
    }
}