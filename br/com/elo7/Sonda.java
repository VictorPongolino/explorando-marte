package br.com.elo7;

public class Sonda implements Movimentacao {

    private Malha posicao;
    
    public Sonda(Malha localizacao) {
        this.posicao = localizacao;
    }

    @Override
    public void mover(OpcoesMovimentos movimento) {
        
    }

    @Override
    public void rotacionar() {
    }
    
}
