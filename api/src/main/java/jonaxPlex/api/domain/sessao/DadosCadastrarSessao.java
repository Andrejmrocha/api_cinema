package jonaxPlex.api.domain.sessao;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosCadastrarSessao(
        @NotNull
        LocalDate data,
        @NotNull
        LocalTime hora,
        @Positive
        Long id_filme,
        @Positive
        Long id_sala
) {
}
