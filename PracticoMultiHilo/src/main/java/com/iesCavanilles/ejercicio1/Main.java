package com.iesCavanilles.ejercicio1;

public class Main {
    static void main(String[] args) {
        Thread hilo1 = new Thread(new HiloAuxiliar());
        System.out.println("Estado: " + hilo1.getState());

        hilo1.start();
        System.out.println("Estado: " + hilo1.getState());

        try{
            hilo.join();
            System.out.println("Estado: " + hilo1.getState());
        }catch(InterruptedException e){
            System.out.println("Hilo interrupted");
        }
    }
}
