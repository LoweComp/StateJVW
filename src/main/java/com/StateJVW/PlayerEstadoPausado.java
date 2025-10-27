package com.StateJVW;

public class PlayerEstadoPausado implements EstadoPlayer{
    @Override
    public String apertarPlay(Player player) {
        player.setEstado(new PlayerEstadoTocando());
        return "Comando PLAY. Retomando reprodução.";
    }
    @Override
    public String apertarPause(Player player) {
        return "Comando PAUSE. Já está pausado.";
    }
    @Override
    public String apertarStop(Player player) {
        player.setEstado(new PlayerEstadoParado());
        return "Comando STOP. Reprodução encerrada e Player parado.";
    }
}
