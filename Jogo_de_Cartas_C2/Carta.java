package Trabalhos_Avaliações.Jogo_de_Cartas_C2;

public abstract class Carta {

    private String nome;
    private int poder;
    protected int cartasJogadas; // revisar isso aqui
    
    public Carta(String nome, int poder) {
        this.nome = nome;
        this.poder = poder;
    }

    public String getNome() {
        return nome;
    }

    public int getPoder() {
        return poder;
    }

    public int getCartasJogadas() {
        return cartasJogadas;
    }

    @Override
    public String toString() {
        return String.format(" =================================== \n"
        + "|| %s \t ||\n"
        + "|| \t\t ||\n"
        + "|| %i \t ||\n"
        + "|| \t\t ||\n", 
        getNome(), getPoder());
    }

    public abstract void jogar(Jogador jogAtivo, Jogador jogAtacado);

}
