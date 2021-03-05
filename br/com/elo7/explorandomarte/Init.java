package br.com.elo7.explorandomarte;

import br.com.elo7.explorandomarte.localizacao.*;
import br.com.elo7.explorandomarte.localizacao.exceptions.*;

public class Init {
    public static void main(String[] args) {

        // Ex-01
        try {
            int x = 7;
            int y = 7;
            int coordenadaNaveX = 1;
            int coordenadaNaveY = 2;
            Sonda umaSonda = new Sonda(new Malha(x, y), coordenadaNaveX, coordenadaNaveY);

            umaSonda.mandarControle("LMLMLMLMM");
            umaSonda.imprimir();
        } catch (CoordenadaInvalidaException e) {
            System.out.println(e);
        }

        // Ex-02
        try {
            int x = 7;
            int y = 7;
            int coordenadaNaveX = 3;
            int coordenadaNaveY = 3;
            Sonda segundaSonda = new Sonda(new Malha(x, y), coordenadaNaveX, coordenadaNaveY, RosasDosVentos.E);
            segundaSonda.mandarControle("MMRMMRMRRM");
            segundaSonda.imprimir();
        } catch (CoordenadaInvalidaException e) {
            System.out.println(e);
        }
    }
}