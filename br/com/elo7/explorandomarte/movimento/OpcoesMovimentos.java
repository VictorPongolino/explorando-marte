package br.com.elo7.explorandomarte.movimento;


public enum OpcoesMovimentos {
    FRENTE(1),
    ESQUERDA(2),
    DIREITA(3);

    private int valor;

    private OpcoesMovimentos(int valor) {
        this.valor = valor;
    }
}