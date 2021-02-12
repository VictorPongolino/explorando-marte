package br.com.elo7.explorandomarte;

import br.com.elo7.explorandomarte.localizacao.Malha;
import br.com.elo7.explorandomarte.movimento.*;

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
