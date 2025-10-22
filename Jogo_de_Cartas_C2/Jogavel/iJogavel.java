package Jogavel;

// Métodos:
// • atacar → recebe o poder e não retorna nada.
// Esse método, quando implementado, reduz a defesa do jogador atacado (inimigo);
// se a defesa cair abaixo de zero, perde 1 ponto de vida e a defesa é aumentada em
// +100. Por exemplo, se a defesa cair para -20, deve aumentar em 100 e ir para 80.

// • defender(int poder) → recebe o poder e não retorna nada
// Esse método aumenta a defesa do jogador

// • estaVivo → que retorna um booleano
// Esse método retorna true se a vida ou a defesa forem maiores que zero.

public interface iJogavel {

    public void atacar(int poder);

    public void defender(int poder);

    public boolean vivo();

}
