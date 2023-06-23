package jonaxPlex.api.domain.filme;

public record DadosListagemFilme(
        Long id,
        String nome,
        int ano,
        int duracao,
        int classificacao,
        Genero genero,
        String imagem
) {
    public DadosListagemFilme(Filme filme){
        this(filme.getId(), filme.getNome(), filme.getAno(), filme.getDuracao(), filme.getClassificacao(), filme.getGenero(), filme.getImagem());
    }
}
