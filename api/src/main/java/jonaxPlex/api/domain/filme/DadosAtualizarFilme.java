package jonaxPlex.api.domain.filme;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizarFilme(
        @NotBlank
        Long id,
        String nome,
        int ano,
        int duracao,
        int classificacao,
        Genero genero,
        String imagem
) {
}
