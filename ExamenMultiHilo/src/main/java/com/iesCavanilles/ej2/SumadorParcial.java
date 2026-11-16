package com.iesCavanilles.ej2;

/**
 * EJERCICIO 2 — Suma paralela ➕
 * Practicas: heredar de Thread, repartir trabajo, guardar el resultado en el hilo.
 *
 * Cada SumadorParcial suma SOLO su trozo del array: posiciones [desde, hasta)
 * (desde incluido, hasta excluido).
 */
public class SumadorParcial extends Thread {

    private final int[] datos;
    private final int desde;
    private final int hasta;
    private long resultado; // aquí guarda el hilo lo que ha sumado

    public SumadorParcial(int[] datos, int desde, int hasta) {
        this.datos = datos;
        this.desde = desde;
        this.hasta = hasta;
    }

    @Override
    public void run() {
        // TODO: suma datos[desde] ... datos[hasta - 1] y guárdalo en 'resultado'.
        //       Opcional: imprime "<getName()> ha sumado [desde, hasta) = resultado"
    }

    public long getResultado() {
        return resultado;
    }
}
