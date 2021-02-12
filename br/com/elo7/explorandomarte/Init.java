package br.com.elo7.explorandomarte;

import br.com.elo7.explorandomarte.localizacao.*;

public class Init {
    public static void main(String[] args) {
        int x = 5;
        int y = 5;
        int coordenadaNaveX = 1;
        int coordenadaNaveY = 2;
        Sonda umaSonda = new Sonda(new Malha(x, y), coordenadaNaveX, coordenadaNaveY);

        umaSonda.imprimir();
        umaSonda.mandarControle("LMLMLMLMM");
        umaSonda.imprimir();

        coordenadaNaveX = 3;
        coordenadaNaveY = 3;
        Sonda segundaSonda = new Sonda(new Malha(x, y), coordenadaNaveX, coordenadaNaveY, RosasDosVentos.LESTE);
        segundaSonda.imprimir();
        segundaSonda.mandarControle("MMRMMRMRRM");
        segundaSonda.imprimir();

    }
}