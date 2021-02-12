package br.com.elo7.explorandomarte;

import br.com.elo7.explorandomarte.localizacao.*;
import br.com.elo7.explorandomarte.movimento.*;

public class Sonda implements Movimentacao {

    private Malha malha;
    private int coordenadaSondaX = 0, coordenadaSondaY = 0;
    private RosasDosVentos ultimaRotacao = RosasDosVentos.NORTE; 

    public Sonda(Malha localizacao) {
        this.malha = localizacao;
    }

    public Sonda(Malha localizacao, int coordenadaSondaX, int coordenadaSondaY)
    {
        this(localizacao);
        this.coordenadaSondaX = coordenadaSondaX;
        this.coordenadaSondaY = coordenadaSondaY;
    }

    @Override
    public String toString() {
        return "(" + coordenadaSondaX + "," + coordenadaSondaY + ", " + ultimaRotacao + ")";
    }

    public void imprimir() {
        System.out.println(this);
    }

    public void mandarControle(String controles) {
        if (controles != null && !controles.isEmpty())
        {
            for (int i = 0; i < controles.length(); i++)
            {
                char caractere = controles.toUpperCase().charAt(i);
                if (caractere == 'M')
                    moverFrente();
                else if (caractere == 'L')
                    rotacionar(OpcoesMovimentos.ESQUERDA);
                else if (caractere == 'R')
                    rotacionar(OpcoesMovimentos.DIREITA);
                else 
                    throw new IllegalArgumentException("Apenas M, L, R são permitidos para controlar a nave !");
            }
        }
        else
            throw new IllegalArgumentException("Parâmetro de controle deve ter no mínimo 1 caractere de M, L, R !");
    }

    public void moverFrente()
    {
        this.mover(OpcoesMovimentos.FRENTE);
    }

    @Override
    public void mover(OpcoesMovimentos movimento) {
        int x = coordenadaSondaX;
        int y = coordenadaSondaY;

        if (movimento == OpcoesMovimentos.FRENTE)
        {
            if (ultimaRotacao == RosasDosVentos.NORTE)
                y++;
            else if (ultimaRotacao == RosasDosVentos.SUL)
                y--;

            if (ultimaRotacao == RosasDosVentos.LESTE)
                x++;
            else if (ultimaRotacao == RosasDosVentos.OESTE)
                x--;
        }

        if (!isValidCoordenada(x, y)) {
            System.out.println("Atingiu os limites do Array !");
            return;
        }
        
        coordenadaSondaX = x;
        coordenadaSondaY = y;
        imprimir();
    }

    public boolean isValidCoordenada(int x, int y)
    {
        int matrizX = malha.getMatrizX();
        int matrizY = malha.getMatrizY();

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
        imprimir();
    }
    
}
