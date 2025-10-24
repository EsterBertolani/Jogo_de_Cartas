package Cartas;

import Jogavel.Jogador;

public class CartaAtaque extends Carta {

    public CartaAtaque(String nome, int poder) {
        super(nome, poder);
    }

    @Override
    public void jogar(Jogador jogAtivo, Jogador jogAtacado) {
        jogAtacado.atacar(this.getPoder());
        Carta.cartasJogadas++;
    }

}
