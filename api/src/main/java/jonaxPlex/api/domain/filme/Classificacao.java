package jonaxPlex.api.domain.filme;

public enum Classificacao {
    LIVRE(0),
    MAIOR_10(10),
    MAIOR_12(12),
    MAIOR_14(14),
    MAIOR_16(16),
    MAIOR_18(18);

    private int idade;

    Classificacao(int idade){
        this.idade = idade;
    }

    public int getIdade(){
        return idade;
    }
}
