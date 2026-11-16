package com.iesCavanilles.ejercicio3;

public class Main {
    public static void main(String[] args) {

        Cuenta cuentaA = new Cuenta(1, 4567);
        Cuenta cuentaB = new Cuenta(2, 789);

        Transferencia trans1 = new Transferencia(cuentaA, cuentaB, 257);
        Transferencia trans2 =new Transferencia(cuentaB, cuentaA, 542);

        Thread t1 = new Thread(trans1);
        Thread t2 = new Thread(trans2);

        t1.start();
        t2.start();

        try{
            t1.join;
            t2.join;

            if(hilo1.isAlive){
                System.out.println("Hilo 1 vivito y coleando");
            }else if (hilo2.isAlive){
                System.out.println("Hilo 2 vivito y coleando");
            }
        }
    }

    public static class Cuenta{
        public int id;
        public double saldo;

        public Cuenta(int id, double saldo) {
            this.id = id;
            this.saldo = saldo;
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

        public void ingresar(int cantidad){
            this.saldo += cantidad;
        }

        public void retirar(int cantidad){
            this.saldo -= cantidad;
        }
    }

    public static class Transferencia implements Runnable{
        Cuenta cuentaEmisora;
        Cuenta cuentaReceptora;
        int dinero;

        @Override
        public void run(){

            Cuenta cuenta1;
            Cuenta cuenta2;
            if (cuentaEmisora.getId() > cuentaReceptora.getId()){
                cuenta1 = cuentaReceptora;
                cuenta2 = cuentaEmisora;
            }
            synchronized (cuentaEmisora){
                cuentaEmisora.retirar(dinero);
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (cuentaReceptora){
                    cuentaReceptora.ingresar(dinero);
                }

            }
        }

        public Transferencia(Cuenta emisora, Cuenta receptora, int cantidad){
            this.cuentaEmisora = emisora;
            this.cuentaReceprotra = receptora;
            this.cantidad = cantidad;
        }
    }
}
