package com.iesCavanilles.ej5;

/**
 * PRODUCTOR: hornea las barras 1, 2, 3 ... numBarras y las deja en la estantería.
 */
public class Panadero implements Runnable {

    /** Valor especial que significa "ya no hay más pan, vete a casa". */
    public static final int FIN = -1;

    private final Estanteria estanteria;
    private final int numBarras;
    private final int numClientes;

    public Panadero(Estanteria estanteria, int numBarras, int numClientes) {
        this.estanteria = estanteria;
        this.numBarras = numBarras;
        this.numClientes = numClientes;
    }

    @Override
    public void run() {
        // TODO 1: Para cada barra de 1 a numBarras:
        //           - duerme 200 ms (está horneando)
        //           - la pone en la estantería
        //           - imprime "Panadero hornea la barra X"
        //
        // TODO 2: Cuando acabe, pon el valor FIN en la estantería UNA VEZ POR CADA CLIENTE,
        //         para que todos los clientes se enteren de que tienen que irse.
        //         (Pregunta: ¿qué pasaría si solo pusieras un FIN y hay 2 clientes?)
        //
        // Recuerda: sleep() y poner() lanzan InterruptedException -> try/catch
    }
}
