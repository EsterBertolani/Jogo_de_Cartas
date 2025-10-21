package Trabalhos_Avaliações.Jogo_de_Cartas_C2;

public class CartaAtaque extends Carta {

    public CartaAtaque(String nome, int poder) {
        super(nome, poder);
    }

    @Override
    public void jogar(Jogador jogAtivo, Jogador inimigo) {
        jogAtivo.atacar(this.getPoder());
        this.cartasJogadas++;
    }

}
