package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import Cartas.Carta;
import Cartas.CartaAtaque;
import Cartas.CartaDefesa;
import Jogavel.Jogador;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Carta> baralho = new ArrayList<>(7);
        Jogador player1 = new Jogador("Aloy");
        Jogador player2 = new Jogador("Crash");

        baralho = new ArrayList<Carta>(7);
        cadastrarCartas(baralho);

        executarJogo(player1, player2, baralho);

    }

    // a) Cadastro Inicial
    // • Criar:
    // • 2 jogadores com nomes distintos.
    // • 4 cartas de ataque com poderes: 10, 20, 30 e 40.
    // • 3 cartas de defesa com poderes: 10, 15 e 20.

    public static void cadastrarCartas(ArrayList<Carta> baralho) {
        CartaAtaque carta1 = new CartaAtaque("Flecha normal", 10);
        CartaAtaque carta2 = new CartaAtaque("Flecha de Fogo", 20);
        CartaAtaque carta3 = new CartaAtaque("Lança", 30);
        CartaAtaque carta4 = new CartaAtaque("Bomba Explosiva", 40);

        CartaDefesa carta5 = new CartaDefesa("Salto", 10);
        CartaDefesa carta6 = new CartaDefesa("Desvio", 15);
        CartaDefesa carta7 = new CartaDefesa("Escudo", 20);

        baralho.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5, carta6, carta7));

        Collections.shuffle(baralho);
    }

    // b) Laço Principal do Jogo
    // Executar enquanto houver mais de um jogador vivo e a quantidade de cartas
    // jogadas for menor ou igual a 30.

    public static void executarJogo(Jogador j1, Jogador j2, ArrayList<Carta> baralho) {
        while (verificarVivos(j1, j2) && (Carta.getCartasJogadas() <= 30)) {
            executarRodada(j1, j2, baralho);
        }

    }

    public static boolean verificarVivos(Jogador j1, Jogador j2) {
        if ((j1.vivo()) && (j2.vivo())) {
            return true;
        } else {
            return false;
        }
    }

    public static void executarRodada(Jogador j1, Jogador j2, ArrayList<Carta> baralho) {
        if ((baralho.isEmpty())) {
            cadastrarCartas(baralho);

            Carta cartaJog1 = baralho.removeFirst();
            cartaJog1.jogar(j1, j2);
            System.out.println(getStatus(j1, j2, cartaJog1));

            if (j2.vivo()) {
                Carta cartaJog2 = baralho.removeFirst();
                cartaJog2.jogar(j2, j1);
                System.out.println(getStatus(j2, j1, cartaJog2));
            } else {
                System.out.println(fimDeJogo(j1, j2));
            }
        }

    }

    public static String getStatus(Jogador jogAtivo, Jogador jogAtacado, Carta cartaJogAtivo) {
        return String.format("\n===== STATUS DOS JOGADORES ===== \n"
                + "|| [%s] jogou [%s --> %s pts] em [%s]\n"
                + "========================================\n"
                + "|| %s --> Vida: %s   | Defesa: %s   ||\n"
                + "|| %s --> Vida: %s   | Defesa: %s   ||\n",
                jogAtivo.getNome(), cartaJogAtivo.getNome(), cartaJogAtivo.getPoder(), jogAtacado.getNome(),
                jogAtivo.getNome(), jogAtivo.getVida(), jogAtivo.getDefesa(),
                jogAtacado.getNome(), jogAtacado.getVida(), jogAtacado.getDefesa());

    }

    public static String fimDeJogo(Jogador jogAtivo, Jogador jogAtacado) {
        return String.format("\n===== FIM DE JOGO ===== \n"
                + "   -- status dos jogadores --\n"
                + "|| %s --> Vida: %s   | Defesa: %s   ||\n"
                + "|| %s --> Vida: %s   | Defesa: %s   ||\n"
                + "========================================\n"
                + "VENCEDOR: [%s]\n"
                + "Total de Cartas jogadas: %s\n",
                jogAtivo.getNome(), jogAtivo.getVida(), jogAtivo.getDefesa(),
                jogAtacado.getNome(), jogAtacado.getVida(), jogAtacado.getDefesa(),
                /* getVencedor(), */
                Carta.getCartasJogadas());
    }

    // Dentro do laço:
    // 1. Cada jogador vivo recebe uma carta aleatória, que pode ser de defesa ou de
    // ataque.
    // 2. O jogador 1 executa sua jogada contra o jogador 2.
    // 3. Se o jogador 2 ainda estiver vivo, ele também joga.
    // 4. Exibir o resultado parcial da rodada, mostrando:
    // • Nome do jogador,
    // • Nome do inimigo,
    // • Tipo de carta jogada,
    // • Situação atual de vida e defesa de cada um.

    // c) Fim do Jogo - o jogo se encerra quando:
    // • houver apenas um jogador vivo → ele é o vencedor.
    // • ou quando as 30 cartas forem jogadas → vence o jogador com:
    // • maior número de vidas;
    // • em caso de empate, o de maior defesa.

    // d) Exibir Resultado Final
    // • Mostrar a lista de jogadores com suas vidas e defesas finais.
    // • Exibir o número total de cartas jogadas.
    // • Indicar o vencedor.

}
