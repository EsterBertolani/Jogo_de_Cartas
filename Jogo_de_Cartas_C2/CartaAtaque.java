package Trabalhos_Avaliações.Jogo_de_Cartas_C2;

public class CartaAtaque extends Carta {

    public CartaAtaque(String nome, int poder) {
        super(nome, poder);
    }

    @Override
    public void jogar(Jogador jogAtivo, Jogador jogAtacado) {
        // ataca o inimigo com o poder da carta
        this.cartasJogadas++;
    }

}
