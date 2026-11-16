package com.iesCavanilles.ej3;

/**
 * EJERCICIO 3 — Contador de visitas 🔢
 * Practicas: condición de carrera y synchronized.
 */
public class ContadorWeb {

    private int visitas = 0;

    /** Versión INSEGURA. Ya está hecha: úsala para ver el fallo. No la toques. */
    public void visitarInseguro() {
        visitas++;
    }

    /** Versión SEGURA: debe sumar 1 sin perder nunca ninguna visita. */
    public void visitar() {
        // TODO: haz lo mismo que visitarInseguro() pero protegido.
        //       Prueba primero poniendo 'synchronized' en el método,
        //       y luego cámbialo por un bloque synchronized(this) { ... }
    }

    public int getVisitas() {
        return visitas;
    }
}
