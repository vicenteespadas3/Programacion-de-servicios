package com.iesCavanilles.ejercicio2;

public class Ingresar implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++){
            CuentaBancaria.setSaldo(CuentaBancaria.saldo + 100);
        }
    }
}
