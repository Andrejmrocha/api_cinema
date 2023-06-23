package jonaxPlex.api.domain.sala;

public record DadosListagemSala(
        Long id,
        int capacidade
) {

    public DadosListagemSala(Sala sala){
        this(sala.getId(), sala.getCapacidade());
    }
}
