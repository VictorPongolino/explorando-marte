package br.com.elo7.explorandomarte.localizacao;

/**
 * Enumeração que indica a direção da sonda.
 * @author VICTOR HUGO PONGOLINO
 */
public enum RosasDosVentos {
    NORTE(0),
    LESTE(1),
    SUL(2),
    OESTE(3);

    private int valor;

    private RosasDosVentos(int valor){
        this.valor = valor;
    }

    @Override
    public String toString() {
        return RosasDosVentos.values()[valor].name();
    }
}