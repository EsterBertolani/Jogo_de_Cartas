package Jogavel;

public class Jogador implements iJogavel {

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

    /*
     * =============================================================================
     * =========
     */

    // Métodos:
    // • atacar → recebe o poder e não retorna nada.
    // Esse método, quando implementado, reduz a defesa do jogador atacado
    // (inimigo);
    // se a defesa cair abaixo de zero, perde 1 ponto de vida e a defesa é aumentada
    // em
    // +100. Por exemplo, se a defesa cair para -20, deve aumentar em 100 e ir para
    // 80.

    // • defender(int poder) → recebe o poder e não retorna nada
    // Esse método aumenta a defesa do jogador

    // • estaVivo → que retorna um booleano
    // Esse método retorna true se a vida ou a defesa forem maiores que zero.

    @Override
    public void atacar(int poder) {
        this.defesa -= poder;

        if (this.defesa < 0) {
            this.defesa += 100;
            this.vida--;
        }

    }

    @Override
    public void defender(int poder) {
        this.defesa += poder;
    }

    @Override
    public boolean vivo() {
        if ((this.getVida() > 0) || (this.getDefesa() > 0)) {
            return true;
        } else {
            return false;
        }
    }

}
