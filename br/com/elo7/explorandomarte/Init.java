package br.com.elo7.explorandomarte;

import br.com.elo7.explorandomarte.localizacao.*;
import br.com.elo7.explorandomarte.movimento.OpcoesMovimentos;

public class Init {
    public static void main(String[] args) {
        final int x = 5;
        final int y = 5;
        Sonda umaSonda = new Sonda(new Malha(x, y));

        umaSonda.imprimir();
        umaSonda.moverFrente();
    }
}