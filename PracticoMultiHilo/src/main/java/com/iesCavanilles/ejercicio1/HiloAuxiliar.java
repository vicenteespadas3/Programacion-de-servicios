package com.iesCavanilles.ejercicio1;

public class HiloAuxiliar extends Thread {
    public void ejercicio1() {
        for(int i = 0; i < 11; i++){
            try{
                sleep(150);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Hola Buenas");
        }
    }
}
