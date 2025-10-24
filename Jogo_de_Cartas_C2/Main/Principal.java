package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import Cartas.Carta;
import Cartas.CartaAtaque;
import Cartas.CartaDefesa;
import Jogavel.Jogador;

public class Principal {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Carta> baralho = new ArrayList<>(7);
        cadastrarCartas(baralho);

        System.out.print("Digite o nome do Player 1: ");
        String nome_p1 = scan.nextLine();
        Jogador player1 = new Jogador(nome_p1);

        System.out.print("Digite o nome do Player 2: ");
        String nome_p2 = scan.nextLine();
        Jogador player2 = new Jogador(nome_p2);

        System.out.println("Pressione 'Enter' para iniciar o jogo...");
        scan.nextLine();

        executarJogo(baralho, player1, player2);

        scan.close();
    }

    // ============== ORGANIZAÇÃO DE MÉTODOS ==============

    // -- Executa o jogo

    public static void executarJogo(ArrayList<Carta> baralho, Jogador player1, Jogador player2) {
        int rodada = 1;

        while (verificarVivos(player1, player2) && (Carta.getCartasJogadas() < 30)) {

            System.out.printf("\n ======== RODADA [%s] ======== \n", rodada); // só pra organizar melhor

            playerDaVez(baralho, player1, player2);

            System.out.println("\nPressione 'Enter' para continuar...");
            scan.nextLine();

            playerDaVez(baralho, player2, player1);

            rodada++;
        }

        System.out.println(fimDeJogo(player1, player2));
    }

    // -- Cadastra cartas no baralho

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

    // -- Verifica se os jogadores ainda estão vivos

    public static boolean verificarVivos(Jogador j1, Jogador j2) {
        if ((j1.vivo()) && (j2.vivo())) {
            return true;
        } else {
            return false;
        }
    }

    // -- Mostra a carta que foi jogada e o status parcial dos jogadores

    public static String mostrarCarta(Carta cartaJogada, Jogador jogAtivo, Jogador inimigo) {
        if (cartaJogada instanceof CartaAtaque) {
            return String.format("\n >>>>>>>>>>>> ATAQUE <<<<<<<<<<<< \n"
                    + "[%s] jogou [%s --> %s pts] em [%s]\n" + getStatus(jogAtivo, inimigo),
                    jogAtivo.getNome(), cartaJogada.getNome(), cartaJogada.getPoder(), inimigo.getNome());
        } else {
            return String.format("\n >>>>>>>>>>>> DEFESA <<<<<<<<<<<< \n"
                    + "[%s] usou [%s --> %s pts]\n" + getStatus(jogAtivo, inimigo),
                    jogAtivo.getNome(), cartaJogada.getNome(), cartaJogada.getPoder());
        }
    }

    public static String getStatus(Jogador jogAtivo, Jogador inimigo) {
        return String.format("\n ======== STATUS DOS JOGADORES ======== \n"
                + "|| %-" + 8 + "s --> Vida: %" + 2 + "s | Defesa: %" + 3 + "s ||\n"
                + "|| %-" + 8 + "s --> Vida: %" + 2 + "s | Defesa: %" + 3 + "s ||\n"
                + " =======================================\n",
                jogAtivo.getNome(), jogAtivo.getVida(), jogAtivo.getDefesa(),
                inimigo.getNome(), inimigo.getVida(), inimigo.getDefesa());
    }

    // controla quem está jogando

    public static void playerDaVez(ArrayList<Carta> baralho, Jogador jogAtivo, Jogador inimigo) {
        if (jogAtivo.vivo()) {
            if (baralho.isEmpty()) {
                cadastrarCartas(baralho);
            }

            Carta cartaJogada = baralho.removeFirst();

            System.out.printf("Player da vez: [%s]\nPressione 'Enter' para jogar", jogAtivo.getNome());
            scan.nextLine();

            cartaJogada.jogar(jogAtivo, inimigo);

            System.out.println(mostrarCarta(cartaJogada, jogAtivo, inimigo));

        } else {
            System.out.printf("\nPlayer [%s] está morto!", jogAtivo.getNome());
        }
    }

    public static String fimDeJogo(Jogador player1, Jogador player2) {
        Jogador vencedor = vencedor(player1, player2);

        String nomeVencedor;
        if (vencedor == null) {
            nomeVencedor = "Empate!";
        } else {
            nomeVencedor = vencedor.getNome().toUpperCase();
        }
        return String.format("\n >>>>>>>>>>>> FIM DE JOGO <<<<<<<<<<<< \n"
                + getStatus(player1, player2)
                + "|| %-" + 35 + "s ||\n"
                + "|| %-" + 35 + "s ||\n"
                + " =======================================\n",
                "Vencedor: [" + nomeVencedor + "]",
                "Cartas jogadas: [" + Carta.getCartasJogadas() + "]");
    }

    public static Jogador vencedor(Jogador player1, Jogador player2) {
        boolean p1Vivo = player1.vivo();
        boolean p2Vivo = player2.vivo();

        // nocaute
        if (p1Vivo && !p2Vivo) {
            return player1;
        }
        if (!p1Vivo && p2Vivo) {
            return player2;
        }

        // ambos vivos, 30 cartas

        if (player1.getVida() > player2.getVida()) { // maior número de vidas
            return player1;
        }
        if (player2.getVida() > player1.getVida()) {
            return player2;
        }

        // maior defesa
        if (player1.getDefesa() > player2.getDefesa()) {
            return player1;
        }
        if (player2.getDefesa() > player1.getDefesa()) {
            return player2;
        }

        return null; // empate total
    }

}
