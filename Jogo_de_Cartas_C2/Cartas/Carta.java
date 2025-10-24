package Cartas;

import Jogavel.Jogador;

public abstract class Carta {

    private String nome;
    private int poder;
    protected static int cartasJogadas = 0;

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

    public static int getCartasJogadas() {
        return cartasJogadas;
    }

    @Override
    public String toString() {
        return String.format(
                "======================= \n"
                        + "|| %-" + 21 + "s ||\n"
                        + "|| %-" + 21 + "s ||\n"
                        + "|| %-" + 21 + "s ||\n"
                        + "|| %-" + 21 + "s ||\n"
                        + " ======================== \n",
                getNome(),
                "",
                "Poder: " + getPoder(),
                "");
    }

    public abstract void jogar(Jogador jogAtivo, Jogador jogAtacado);

}
