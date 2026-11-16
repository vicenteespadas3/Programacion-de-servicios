package com.iesCavanilles.ej3;

public class SimuladorVisitas {

    /**
     * Lanza 'numHilos' hilos. Cada hilo llama 'visitasPorHilo' veces al contador:
     *   - si seguro == true  -> contador.visitar()
     *   - si seguro == false -> contador.visitarInseguro()
     * Espera a que terminen todos y devuelve contador.getVisitas().
     */
    public static int simular(ContadorWeb contador, int numHilos, int visitasPorHilo, boolean seguro) {

        // TODO 1: Crea los hilos. Aquí no hay clase hecha: puedes
        //         a) crear una clase Visitante implements Runnable, o
        //         b) usar una lambda:  new Thread(() -> { ... })
        //         (Ojo: dentro de una lambda solo puedes usar variables "efectivamente final".)
        // TODO 2: Arráncalos todos.
        // TODO 3: join() de todos.

        return contador.getVisitas();
    }
}
