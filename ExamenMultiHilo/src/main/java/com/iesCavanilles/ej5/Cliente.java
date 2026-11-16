package com.iesCavanilles.ej5;

import java.util.ArrayList;
import java.util.List;

/**
 * CONSUMIDOR: coge barras de la estantería hasta que recibe la señal FIN.
 */
public class Cliente implements Runnable {

    private final String nombre;
    private final Estanteria estanteria;
    private final List<Integer> compradas = new ArrayList<>(); // solo la usa este cliente

    public Cliente(String nombre, Estanteria estanteria) {
        this.nombre = nombre;
        this.estanteria = estanteria;
    }

    @Override
    public void run() {
        // TODO: Repite:
        //         - coge una barra de la estantería
        //         - si es Panadero.FIN -> imprime "<nombre> se va a casa" y SAL del bucle
        //           (¡no la añadas a compradas!)
        //         - si no: añádela a 'compradas', imprime "<nombre> compra la barra X"
        //           y duerme 500 ms (se la está comiendo)
        //
        // Pregunta: ¿por qué 'compradas' NO necesita synchronized?
    }

    public String getNombre() {
        return nombre;
    }

    public List<Integer> getCompradas() {
        return compradas;
    }
}
