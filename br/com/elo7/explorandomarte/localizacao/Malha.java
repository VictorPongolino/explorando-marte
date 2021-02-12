package br.com.elo7.explorandomarte.localizacao;

/**
* <p>Representa um matriz de plano 2D (X, Y) dos limites em que uma sonda pode navegar. </p>
* 
* @author VICTOR HUGO PONGOLINO
* 
*/

public class Malha {
    
    private int[][] localizacao;

    /**
     * Cria uma Malha especificando os limites fixos em que uma sonda pode usufluir. Caso a sonda atingir 
     * estes limites, {@code IllegalArgumentException} será disparado.
     * Os limites devem ser positivos ou {@code NegativeArraySizeException} será lançada pelo Runtime.
     * @param x o tamanho da primeira dimensão
     * @param y o tamanho da segunda dimensão
     */
    public Malha(int x, int y) {
        
        this.localizacao = new int[x][y];
    }

    /**
     * Retorna o tamanho da primeira dimensão da Malha.
     * @return tamanho da dimensão X.
     */
    public int getMatrizX () {
        return this.localizacao.length;
    }

     /**
     * Retorna o tamanho da segunda dimensão da Malha.
     * @return tamanho da dimensão Y.
     */
    public int getMatrizY () {
        return this.localizacao[0].length; 
    }
 
}
