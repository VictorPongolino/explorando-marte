package br.com.elo7.explorandomarte;

import br.com.elo7.explorandomarte.localizacao.*;
import br.com.elo7.explorandomarte.movimento.*;

public class Sonda implements Movimentacao {

    private Malha posicao;
    private RosasDosVentos ultimaRotacao = RosasDosVentos.NORTE; 

    public Sonda(Malha localizacao) {
        this.posicao = localizacao;
    }

    @Override
    public String toString() {
        return "(0, 0, " + ultimaRotacao + ")";
    }

    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public void mover(OpcoesMovimentos movimento) {
        int x = posicao.getMatrizX();
        int y = posicao.getMatrizY();

        if (movimento == movimento.FRENTE)
        {
            
        }
    }

    public boolean isValidCoordenada(int x, int y)
    {
        int matrizX = posicao.getMatrizX();
        int matrizY = posicao.getMatrizY();

        return x < matrizX || y < matrizY;
    }

    @Override
    public void rotacionar(OpcoesMovimentos movimento) {
        int index = RosasDosVentos.valueOf(ultimaRotacao.toString()).ordinal();
        if (movimento == OpcoesMovimentos.ESQUERDA) index--;
        else if (movimento == OpcoesMovimentos.DIREITA) index++;

        RosasDosVentos[] listaEnum = RosasDosVentos.values();
        int ultimoIndexEnumeracao = listaEnum.length;
        if (ultimoIndexEnumeracao == index) 
            index = listaEnum[0].ordinal();
        else if (index < 0)
            index = listaEnum[ultimoIndexEnumeracao - 1].ordinal();

        ultimaRotacao = RosasDosVentos.values()[index];
    }
    
}
