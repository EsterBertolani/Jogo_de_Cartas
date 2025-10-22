package Cartas;

import Jogavel.Jogador;

public abstract class Carta {

    private String nome;
    private int poder;
    protected int cartasJogadas;

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
                + "|| \t\t ||\n"
                + " =================================== \n",
                getNome(), getPoder());
    }

    public abstract void jogar(Jogador jogAtivo, Jogador jogAtacado);

}
