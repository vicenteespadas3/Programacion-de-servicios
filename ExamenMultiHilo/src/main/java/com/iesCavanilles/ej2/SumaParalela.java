package com.iesCavanilles.ej2;

public class SumaParalela {

    /**
     * Suma todos los elementos del array repartiendo el trabajo entre 'numHilos' hilos.
     *
     * Ejemplo con 10 elementos y 3 hilos:
     *    hilo 0 -> [0, 3)   hilo 1 -> [3, 6)   hilo 2 -> [6, 10)  <- el último se lleva lo que sobra
     *
     * @return la suma total
     */
    public static long sumar(int[] datos, int numHilos) {
        long total = 0;

        // TODO 1: Calcula el tamaño de cada trozo: datos.length / numHilos
        // TODO 2: Crea un array de SumadorParcial con numHilos posiciones.
        //         Para cada i: desde = i * trozo; hasta = (i == numHilos - 1) ? datos.length : desde + trozo
        //         Créalo y arráncalo.
        // TODO 3: Haz join() de cada sumador y acumula su getResultado() en 'total'.
        //         Pregunta: ¿por qué NO hace falta synchronized en este ejercicio?

        return total;
    }
}
