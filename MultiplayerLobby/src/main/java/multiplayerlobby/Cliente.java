package multiplayerlobby;

import java.util.Scanner;

public class Cliente {

    private static final int CAPACIDAD_MAXIMA = 5;

    public static void main(String[] args) {
        Lobby lobby = new Lobby(CAPACIDAD_MAXIMA);

        try{
            Thread servidor;
            servidor = new Thread(()->lobby.crearPartida());
            servidor.start();

            Scanner sc = new Scanner(System.in);

            while (!lobby.isPartidaIniciada() && lobby.getJugadores().size() < CAPACIDAD_MAXIMA) {
                System.out.println("Introduzca el nombre del jugador nuevo: ");
                String nombreJugador = sc.nextLine();


                try {
                    Thread generadorDeJugadores;
                    generadorDeJugadores = new Thread(()->lobby.unirse(nombreJugador));
                    generadorDeJugadores.start();
                    generadorDeJugadores.join();

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Error al iniciar el jugador");
                }
            }
            servidor.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


    }
}