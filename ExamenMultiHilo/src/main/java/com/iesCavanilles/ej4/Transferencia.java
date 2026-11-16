package com.iesCavanilles.ej4;

/**
 * Tarea que hace 'veces' transferencias de 'cantidad' euros de origen a destino.
 */
public class Transferencia implements Runnable {

    private final Cuenta origen;
    private final Cuenta destino;
    private final double cantidad;
    private final int veces;
    private final boolean segura; // true -> Banco.transferir   false -> Banco.transferirPeligroso

    public Transferencia(Cuenta origen, Cuenta destino, double cantidad, int veces, boolean segura) {
        this.origen = origen;
        this.destino = destino;
        this.cantidad = cantidad;
        this.veces = veces;
        this.segura = segura;
    }

    @Override
    public void run() {
        // TODO: Repite 'veces' veces:
        //          si segura   -> Banco.transferir(origen, destino, cantidad)
        //          si no       -> Banco.transferirPeligroso(origen, destino, cantidad)
        //       Al final imprime "<nombre del hilo actual> ha terminado sus transferencias"
        //       (pista: Thread.currentThread().getName())
    }
}
