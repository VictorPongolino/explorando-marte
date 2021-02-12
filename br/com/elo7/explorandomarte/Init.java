package br.com.elo7.explorandomarte;

import br.com.elo7.explorandomarte.localizacao.*;
import br.com.elo7.explorandomarte.movimento.OpcoesMovimentos;

public class Init {
    public static void main(String[] args) {
        final int x = 5;
        final int y = 5;
        final int coordenadaNaveX = 1;
        final int coordenadaNaveY = 2;
        Sonda umaSonda = new Sonda(new Malha(x, y), coordenadaNaveX, coordenadaNaveY);

        umaSonda.imprimir();
        umaSonda.mandarControle("LMLMLMLMM");
        umaSonda.imprimir();
    }
}