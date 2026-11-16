package com.iesCavanilles.ej1;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    /**
     * Lanza un hilo por cada caracol, espera a que TODOS terminen
     * y devuelve la lista con el orden de llegada.
     *
     * @param nombres nombres de los caracoles
     * @param metros  longitud de la carrera
     * @return lista de nombres en orden de llegada
     */
    public static List<String> correr(String[] nombres, int metros) {
        List<String> llegada = new ArrayList<>();

        // TODO 1: Crea un Caracol y un Thread por cada nombre (dale al Thread el nombre del caracol).
        //         Guarda los Thread en una lista para poder esperarlos después.

        // TODO 2: Arranca todos los hilos (¿start() o run()? 😉).

        // TODO 3: Espera a que terminen TODOS con join().
        //         Si no lo haces, devolverás la lista vacía o a medias.

        return llegada;
    }
}
