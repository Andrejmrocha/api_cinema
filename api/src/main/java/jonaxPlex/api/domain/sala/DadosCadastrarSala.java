package jonaxPlex.api.domain.sala;


import jakarta.validation.constraints.NotNull;

public record DadosCadastrarSala(
        @NotNull
        int capacidade
) {
}
