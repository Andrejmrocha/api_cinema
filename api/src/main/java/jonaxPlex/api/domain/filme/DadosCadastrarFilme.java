package jonaxPlex.api.domain.filme;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarFilme(
        @NotBlank
        String nome,
        @NotNull
        int ano,
        @NotNull
        int duracao,
        @NotNull
        int classificacao,
        Genero genero,
        String imagem
) {
}
