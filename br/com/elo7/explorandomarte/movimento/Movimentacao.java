package br.com.elo7.explorandomarte.movimento;

/**
 * Interface que possibilita meios de locomoção e rotação aos seus elementos.
 * @author VICTOR HUGO PONGOLINO
 */
public interface Movimentacao {
    /**
     * Especifica a movimentação do elemento.
     * @param movimento o movimento que o elemento irá realizar.
     */
    void mover(OpcoesMovimentos movimento);
    /**
     * Rotaciona o elemento a um ângulo de 90 graus de acordo com a direção informada. 
     * @param movimento rotação que o elemento deverá realizar.
     */
    void rotacionar(OpcoesMovimentos rotacao);
}