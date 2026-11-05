package com.iesCavanilles.ejercicio3;

public class Cuenta{
    public int id;
    public double saldo;
    public String nombre;

    public Cuenta(int id, double saldo, String nombre) {
        this.id = id;
        this.saldo = saldo;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
