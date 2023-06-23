package jonaxPlex.api.domain.filme;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Filme")
@Table(name = "filmes")
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int ano;
    private int duracao;
    private int classificacao;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private boolean ativo;
    private String imagem;


    public Filme(String nome, int ano, int duracao, Classificacao classificacao, Genero genero, String imagem){
        this.nome = nome;
        this.ano = ano;
        this.duracao = duracao;
        this.classificacao = classificacao.getIdade();
        this.genero = genero;
        this.ativo = true;
        this.imagem = imagem;
    }

    public Filme(String nome, int ano, int duracao, int classificacao, Genero genero, String imagem) {
        this.nome = nome;
        this.ano = ano;
        this.duracao = duracao;
        this.classificacao = classificacao;
        this.genero = genero;
        this.ativo = true;
        this.imagem = imagem;

    }

    public void atualizarInformacoes(DadosAtualizarFilme dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.ano() != 0){
            this.ano = dados.ano();
        }
        if(dados.duracao() != 0){
            this.duracao = dados.duracao();
        }
        if(dados.classificacao() != 0){
            this.classificacao = dados.classificacao();
        }
        if(dados.genero() != null){
            this.genero = dados.genero();
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
