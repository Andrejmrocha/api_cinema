package jonaxPlex.api.domain.sessao;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosListagemSessao(
        LocalDate data,
        LocalTime hora,
        Long id_filme,
        Long id_sala
) {
    public DadosListagemSessao(Sessao sessao){
        this(sessao.getData(), sessao.getHora(), sessao.getFilme().getId(), sessao.getSala().getId());


    }
}
