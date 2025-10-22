package Cartas;

import Jogavel.Jogador;

public class CartaDefesa extends Carta {

    public CartaDefesa(String nome, int poder) {
        super(nome, poder);
    }

    @Override
    public void jogar(Jogador jogAtivo, Jogador jogAtacado) {
        jogAtacado.defender(this.getPoder());
        this.cartasJogadas++;
    }

}
