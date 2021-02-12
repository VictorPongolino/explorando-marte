package br.com.elo7.explorandomarte.localizacao;

/**
 * Enumeração que indica a direção da sonda.
 * @author VICTOR HUGO PONGOLINO
 */
public enum RosasDosVentos {
    N(0),
    E(1),
    S(2),
    W(3);

    private int valor;

    private RosasDosVentos(int valor){
        this.valor = valor;
    }

    @Override
    public String toString() {
        return RosasDosVentos.values()[valor].name();
    }
}