package com.iesCavanilles.ej4;

/**
 * EJERCICIO 4 — Banco 🏦
 * Esta clase YA ESTÁ HECHA. No la toques.
 * Fíjate en que sus métodos NO son synchronized: la protección la haces tú en Banco.
 */
public class Cuenta {

    private final int id;
    private final String titular;
    private double saldo;

    public Cuenta(int id, String titular, double saldo) {
        this.id = id;
        this.titular = titular;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void ingresar(double cantidad) {
        saldo += cantidad;
    }

    public void retirar(double cantidad) {
        saldo -= cantidad;
    }
}
