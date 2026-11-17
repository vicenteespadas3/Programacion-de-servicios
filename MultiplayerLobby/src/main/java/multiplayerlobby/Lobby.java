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
    }
    
    public synchronized void crearPartida() {
        
    }
    
    public synchronized boolean isPartidaIniciada() {
        return false;
    }

    public synchronized List<String> getJugadores() {
        return new ArrayList<>();
    }
}