package multiplayerlobby;

import java.util.ArrayList;
import java.util.List;

public class Lobby {
    private final List<String> jugadores;
    private boolean partidaIniciada;
    private int capacidadMaxima;

    public Lobby(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.jugadores = new ArrayList<>();
        this.partidaIniciada = false;
    }

    public synchronized void unirse(String nombreJugador) {
        jugadores.add(nombreJugador);
        System.out.println("Un jugador ha entrado en la partida: " + nombreJugador + " (" + jugadores.size() + "/" + capacidadMaxima + ")");
        notifyAll();
    }
    
    public synchronized void crearPartida() {
        System.out.println("Partida creada!");
        System.out.println("Esperando Jugadores");
        try{
            while (jugadores.size() < capacidadMaxima) {
                wait();
            }
            partidaIniciada = true;
            System.out.println("Empezando partida! Jugadores: " + jugadores);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            Thread.currentThread().interrupt();
            partidaIniciada = false;
            System.out.println("Partida interrumpida...");
        }


    }
    
    public synchronized boolean isPartidaIniciada() {
        return partidaIniciada;
    }

    public synchronized List<String> getJugadores() {
        return new ArrayList<>(jugadores);
    }
}