package com.StateJVW;

public class PlayerEstadoTocando implements EstadoPlayer {
    @Override
    public String apertarPlay(Player player) {
        return "Comando PLAY. A faixa já está tocando.";
    }
    @Override
    public String apertarPause(Player player) {
        player.setEstado(new PlayerEstadoPausado());
        return "Comando PAUSE. Reprodução suspensa.";
    }
    @Override
    public String apertarStop(Player player) {
        player.setEstado(new PlayerEstadoParado());
        return "Comando STOP. Reprodução encerrada e Player parado.";
    }
}
