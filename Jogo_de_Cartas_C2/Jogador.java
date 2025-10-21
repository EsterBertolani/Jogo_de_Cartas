package Trabalhos_Avaliações.Jogo_de_Cartas_C2;

public class Jogador {

    private String nome;
    private int vida;
    private int defesa;

    public Jogador(String nome) {
        this.nome = nome;
        this.vida = 2;
        this.defesa = 50;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getDefesa() {
        return defesa;
    }

    

}
