package com.iesCavanilles.ej1;

import java.util.List;

/**
 * EJERCICIO 1 — Carrera de caracoles 🐌
 * Practicas: implementar Runnable, Thread.sleep(), recurso compartido simple.
 */
public class Caracol implements Runnable {

    private final String nombre;
    private final int metros;
    private final List<String> llegada; // lista COMPARTIDA por todos los caracoles

    public Caracol(String nombre, int metros, List<String> llegada) {
        this.nombre = nombre;
        this.metros = metros;
        this.llegada = llegada;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        // TODO 1: Bucle de 1 a 'metros'. En cada vuelta:
        //         - imprime "<nombre> va por el metro X"
        //         - duerme un tiempo aleatorio entre 100 y 400 ms
        //           (pista: (int)(Math.random() * 301) + 100)
        //         - recuerda que sleep lanza InterruptedException
        for (int i = 0; i <= metros; i++) {
            System.out.println("Caracol " + nombre + " va por el metrro:" + i);
            try{
                Thread.sleep(300);

            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        //
        // TODO 2: Al terminar, imprime "<nombre> ha llegado a la meta" y
        //         añade el nombre a la lista 'llegada'.
        //         ¡OJO! Varios caracoles pueden llegar a la vez y la lista es compartida.
        //         Protégela con un bloque synchronized (¿sobre qué objeto?).



    }
}
