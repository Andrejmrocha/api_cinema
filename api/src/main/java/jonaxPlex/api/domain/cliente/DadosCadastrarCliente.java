package jonaxPlex.api.domain.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarCliente(
        @NotBlank
        String nome,
        @NotNull
        int idade,
        @NotBlank
        @Email
        String email,
        String telefone
) {
}
