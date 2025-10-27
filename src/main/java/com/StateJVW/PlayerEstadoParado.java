package com.StateJVW;

public class PlayerEstadoParado implements EstadoPlayer{
    @Override
    public String apertarPlay(Player player) {
        player.setEstado(new PlayerEstadoTocando());
        return "Comando PLAY. Iniciando reprodução.";
    }
    @Override
    public String apertarPause(Player player) {
        return "Comando PAUSE. Não é possível pausar se estiver parado.";
    }
    @Override
    public String apertarStop(Player player) {
        return "Comando STOP. Já está parado.";
    }
}
