package br.com.elo7.explorandomarte;

import br.com.elo7.explorandomarte.localizacao.*;
import br.com.elo7.explorandomarte.movimento.*;
import br.com.elo7.explorandomarte.localizacao.exceptions.*;

/**
 * Uma sonda explora a malha de um planalto.
 * Para o controle da movimentação e da direção da sonda é recomendado o método {@code mandarControle} 
 * especificando seus controles.
 * @author VICTOR HUGO PONGOLINO
 */
public class Sonda implements Movimentacao {
    
    private Coordenada coordenada;
    
    /**
     * A instância que determina o espaço limite em que a sonda pode interagir.
     */
    private Malha malha;

    /**
     * A atual direção da nave para a movimentação sobre o planalto. 
     */
    private RosasDosVentos ultimaRotacao = RosasDosVentos.N; 

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
    public Sonda(Malha localizacao, int x, int y)
    {
        this(localizacao);
        this.coordenada = new Coordenada(this.malha, x, y);
    }

    /***
     * Cria uma sonda que poderá navegar sobre um malha de planalto através de comandos de controle.
     * 
     * @param localizacao a malha que especificará o espaço em que a sonda pode interagir.
     * @param coordenadaSondaX as coordenadas inicias X.
     * @param coordenadaSondaY as coordenadas inicias Y.
     * @param rotacaoInicial a rotação inicial da sonda.
     */
    public Sonda (Malha localizacao, int x, int y, RosasDosVentos rotacaoInicial) {
        this(localizacao, x, y);
        this.ultimaRotacao = rotacaoInicial;
    }

    /**
     * Imprime as Coordenadas atuais da sonda e a sua direção em relação a rosas dos ventos.
     */
    @Override
    public String toString() {
        return this.coordenada + " " + ultimaRotacao;
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
    public void mandarControle(String controles) throws IllegalArgumentException {
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
    public void mover(OpcoesMovimentos movimento) throws CoordenadaInvalidaException {
        int x = this.coordenada.getX();
        int y = this.coordenada.getY();

        if (movimento == OpcoesMovimentos.FRENTE)
        {
            if (ultimaRotacao == RosasDosVentos.N)
                y++;
            else if (ultimaRotacao == RosasDosVentos.S)
                y--;

            if (ultimaRotacao == RosasDosVentos.E)
                x++;
            else if (ultimaRotacao == RosasDosVentos.W)
                x--;
        }

        this.coordenada.tryAlterar(x, y);
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
