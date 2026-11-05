package com.iesCavanilles.ejercicio2;

public class CuentaBancaria {

    public static double saldo = 1000;

    public void main(String[] args){
        for(int i = 0; i < 10; i++){
            Thread t1 =  new Thread( new Extraer());
            t1.start();
        }

        for (int i = 10; i < 10; i++){
            Thread t1 =  new Thread( new Ingresar());
            t1.start();
        }
    }

    public synchronized static void setSaldo(double saldo){
        CuentaBancaria.saldo = saldo;
    }
}
