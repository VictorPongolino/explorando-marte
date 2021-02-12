package br.com.elo7;

public class Malha {
    
    private int[][] localizacao;

    public Malha(int x, int y) {
        this.localizacao = new int[x][y];
    }

    public int getMatrizX () {
        return this.localizacao.length;
    }

    public int getMatrizY () {
        return this.localizacao[0].length; 
    }

}
