package br.com.elo7.explorandomarte;

import br.com.elo7.explorandomarte.localizacao.*;
import br.com.elo7.explorandomarte.movimento.*;

/**
 * Uma sonda explora a malha de um planalto.
 * Para o controle da movimentação e da direção da sonda é recomendado o método {@code mandarControle} 
 * especificando seus controles.
 * @author VICTOR HUGO PONGOLINO
 */
public class Sonda implements Movimentacao {
    
    /**
     * Coordenada X da atual localização da sonda.
     */
    private int coordenadaSondaX = 0;

    /**
     * Coordenada Y da atual localização da sonda.
     */
    private int coordenadaSondaY = 0;
    
    /**
     * A instância que determina o espaço limite em que a sonda pode interagir.
     */
    private Malha malha;

    /**
     * A atual direção da nave para a movimentação sobre o planalto. 
     */
    private RosasDosVentos ultimaRotacao = RosasDosVentos.NORTE; 

    /**
     * Cria uma sonda que poderá navegar sobre um malha de planalto através de comandos de controle.
     * @param localizacao a malha que especificará o espaço em que a sonda pode interagir.
     */
    public Sonda(Malha localizacao) {
        this.malha = localizacao;
    }
    /***
     * Cria uma sonda que poderá navegar sobre um malha de planalto através de comandos de controle.
     * 
     * @param localizacao a malha que especificará o espaço em que a sonda pode interagir.
     * @param coordenadaSondaX as coordenadas inicias X.
     * @param coordenadaSondaY as coordenadas inicias Y.
     */
    public Sonda(Malha localizacao, int coordenadaSondaX, int coordenadaSondaY)
    {
        this(localizacao);
        this.coordenadaSondaX = coordenadaSondaX;
        this.coordenadaSondaY = coordenadaSondaY;
    }

    /***
     * Cria uma sonda que poderá navegar sobre um malha de planalto através de comandos de controle.
     * 
     * @param localizacao a malha que especificará o espaço em que a sonda pode interagir.
     * @param coordenadaSondaX as coordenadas inicias X.
     * @param coordenadaSondaY as coordenadas inicias Y.
     * @param rotacaoInicial a rotação inicial da sonda.
     */
    public Sonda (Malha localizacao, int coordenadaSondaX, int coordenadaSondaY, RosasDosVentos rotacaoInicial) {
        this(localizacao, coordenadaSondaX, coordenadaSondaY);
        this.ultimaRotacao = rotacaoInicial;
    }

    /**
     * Imprime as Coordenadas atuais da sonda e a sua direção em relação a rosas dos ventos.
     */
    @Override
    public String toString() {
        return "(" + coordenadaSondaX + "," + coordenadaSondaY + ", " + ultimaRotacao + ")";
    }

    /**
     * Imprime as Coordenadas atuais da sonda e a sua direção em relação a rosas dos ventos.
     */
    public void imprimir() {
        System.out.println(this);
    }

    /**
     * Controla a movimentação e a rotação da sonda através de uma série de comandos especificados em uma {@code String}.
     * Os comandos são: <p>Movimentação: L e R para virar a Esquerda ou Direita e M para avançar para frente</p>
     * A movimentação é de acordo com a sua rotação atual, para saber a rotação atual da sonda use {@code imprimir()}
     * @param controles uma String que deverá conter as letras de controle.
     * @throws IllegalArgumentException caso não seja especificado no mínimo 1 controle ou se for encontrado um controle inválido!
     */
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

    /**
     * Mover a sonda para frente de acordo com a sua rotação atual. 
     */
    public void moverFrente()
    {
        this.mover(OpcoesMovimentos.FRENTE);
    }

    /**
     * Especifica a forma que a sonda se locomove ao ser especificado um parâmetro de entrada.
     * @param movimento a enumeração que detalha qual movimento será feito. 
     * 
     * Caso seja especificado uma enumeração que não seja relacionado a movimentação (Ex: rotação), nada acontecerá.
     */
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
    }

    /**
     * Verifica se a posição 2d (X, Y) está dentro dos limites da malha.
     * @param x Coordenada X
     * @param y Coordenada Y
     * @return retorna TRUE se está dentro ou FALSE se estiver fora dos limites da matriz da malha.
     */
    public boolean isValidCoordenada(int x, int y)
    {
        int matrizX = malha.getMatrizX();
        int matrizY = malha.getMatrizY();

        return x < matrizX || y < matrizY;
    }

    /**
     * Rotaciona a sonda em um ângulo de 90° para direita ou para a esquerda.
     * @param movimento a enumeração especificando qual angulo que a sonda deverá virar (esquerda ou direita.)
     * 
     * Caso seja especificado um valor que não condiz como uma rotação, nada ocorrerá.
     */
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
