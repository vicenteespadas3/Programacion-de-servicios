package com.iesCavanilles.ej5;

import java.util.LinkedList;

/**
 * EJERCICIO 5 — Panadería 🥖 (Productor - Consumidor)
 * Practicas: synchronized + wait() + notifyAll() con un buffer de capacidad > 1.
 *
 * NO uses BlockingQueue: el objetivo es hacerlo a mano.
 */
public class Estanteria {

    private final LinkedList<Integer> barras = new LinkedList<>();
    private final int capacidad;
    private int maximaOcupacion = 0; // lo usa el Main para comprobar que no te pasas de la capacidad

    public Estanteria(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * El panadero deja una barra. Si la estantería está LLENA, espera.
     */
    public synchronized void poner(int barra) throws InterruptedException {
        // TODO 1: Mientras la estantería esté llena -> wait()   (¿while o if? 😉)
        // TODO 2: Añade la barra al final de la lista (addLast)
        // TODO 3: Llama a actualizarMaximo()  (ya está hecho, abajo)
        // TODO 4: Avisa a los que estén esperando (notifyAll)
    }

    /**
     * Un cliente coge la barra más antigua. Si la estantería está VACÍA, espera.
     * @return el número de la barra cogida
     */
    public synchronized int coger() throws InterruptedException {
        // TODO 1: Mientras la estantería esté vacía -> wait()
        // TODO 2: Saca la primera barra de la lista (removeFirst)
        // TODO 3: Avisa a los que estén esperando (notifyAll)
        // TODO 4: Devuelve la barra
        return -1;
    }

    // ---------- Ya hecho, no lo toques ----------
    private void actualizarMaximo() {
        if (barras.size() > maximaOcupacion) {
            maximaOcupacion = barras.size();
        }
    }

    public synchronized int getMaximaOcupacion() {
        return maximaOcupacion;
    }
}
