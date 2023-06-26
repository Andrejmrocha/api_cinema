package jonaxPlex.api.domain.filme;

public record DadosDetalharFilme(Long id, String nome, int ano, int duracao, int classificacao, Genero genero
) {

    public DadosDetalharFilme(Filme filme){
        this(filme.getId(), filme.getNome(), filme.getAno(), filme.getDuracao(),
                filme.getClassificacao(), filme.getGenero());
    }
}
