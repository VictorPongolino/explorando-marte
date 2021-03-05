package br.com.elo7.explorandomarte.localizacao;

import br.com.elo7.explorandomarte.localizacao.exceptions.*;

/**
 * Uma coordenada de uma sonda de acordo com uma malha de um planalto.
 * @author VICTOR HUGO PONGOLINO
 */
public class Coordenada {
    
    private Malha malha;
    private int x, y;

    /**
     * Define uma coordenada 2d (0, 0) da sonda sem um planalto definido.
     * @param x coordenada positiva da matriz (da primeira dimensão) de X.
     * @param y coordenada positiva da matriz (da segunda dimensão) de Y.
     */
    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Define uma coordenada padrão (0,0) da sonda de acordo com o seu planalto.
     * @param malha a malha de um planalto.
     */
    public Coordenada (Malha malha) {
        this.malha = malha;
    }

    /**
     * Define uma coordenada 2d (0, 0) da sonda de acordo com o seu planalto. 
     * @param malha a malha de um planalto.
     * @param x coordenada positiva da matriz (da primeira dimensão) de X.
     * @param y coordenada positiva da matriz (da segunda dimensão) de Y.
     */
    public Coordenada (Malha malha, int x, int y) {
        this(malha);

        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return this.x + "," + this.y;
    }

    /**
     * Imprime as coordenadas atuais da sonda.
     */
    public void imprimirCoordenada() {
        System.out.println(this);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMalha(Malha malha) {
        this.malha = malha;
    }

    
    /**
     * Tenta alterar as coordenadas da sonda verificando se a mesma encontra-se dentro da dimensão de seu planalto.
     * Caso ao contrário {@code CoordenadaInvalidaException} será lançado !
     * Caso a malha não foi especificada no construtor {@code NullPointerException} será lançado, use {@code setMalha} se for este caso.
     * @param x a coordenada X
     * @param y a coordenada Y
     * @throws CoordenadaInvalidaException
     */
    public void tryAlterar(int x, int y) throws CoordenadaInvalidaException {
        if (!isValidCoordenada(this.malha, x, y)) {
            throw new CoordenadaInvalidaException("Coordenada fornecida inválida !");
        }
        else {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Verifica se as coordenadas fornecidas (de acordo com a malha) está correta.
     * @param malha a malha do planalto.
     * @param x coordenada X
     * @param y coordenada Y
     * @return verdadeiro se a coordenada está dentro dos limites permitidos, do contrário, falso.
     */
    public static boolean isValidCoordenada(Malha malha, int x, int y) {
        int limiteX = malha.getMatrizX();
        int limiteY = malha.getMatrizY();

        return x >= 0 && x < limiteX && y >= 0 && y < limiteY;
    }
}
