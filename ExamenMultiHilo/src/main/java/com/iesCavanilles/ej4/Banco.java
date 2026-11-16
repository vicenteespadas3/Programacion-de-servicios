package com.iesCavanilles.ej4;

public class Banco {

    /**
     * VERSIÓN PELIGROSA (ya hecha, NO la toques): bloquea primero el origen y luego el destino.
     * Si un hilo hace A->B y otro B->A a la vez... 💀
     * Ejecuta el ejercicio con "4 peligroso" para verlo.
     */
    public static boolean transferirPeligroso(Cuenta origen, Cuenta destino, double cantidad) {
        synchronized (origen) {
            try {
                Thread.sleep(1); // hace que el deadlock salga casi seguro
            } catch (InterruptedException e) {
                return false;
            }
            synchronized (destino) {
                if (origen.getSaldo() < cantidad) {
                    return false;
                }
                origen.retirar(cantidad);
                destino.ingresar(cantidad);
                return true;
            }
        }
    }

    /**
     * VERSIÓN SEGURA: transfiere 'cantidad' de origen a destino SIN deadlock.
     *
     * @return true si se ha hecho la transferencia, false si el origen no tiene saldo suficiente
     *         (en ese caso NO se mueve dinero).
     */
    public static boolean transferir(Cuenta origen, Cuenta destino, double cantidad) {

        // TODO 1: Decide qué cuenta se bloquea PRIMERO y cuál DESPUÉS
        //         usando el id (por ejemplo, siempre primero la de id más pequeño),
        //         da igual cuál sea el origen y cuál el destino.
        //
        // TODO 2: synchronized (primera) { synchronized (segunda) { ... } }
        //         Dentro: si no hay saldo suficiente -> return false.
        //                 si hay -> retirar del origen, ingresar en destino, return true.
        //
        // Pista: copia la versión peligrosa y cambia SOLO el orden de los cerrojos.

        return false;
    }
}
