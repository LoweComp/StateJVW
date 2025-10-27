package com.StateJVW;

public class Player {
    private EstadoPlayer estadoAtual;
    private String nomeFaixa;

    public Player(String faixaInicial) {
        this.nomeFaixa = faixaInicial;
        this.estadoAtual = new PlayerEstadoParado();
    }

    public void setEstado(EstadoPlayer novoEstado) {
        this.estadoAtual = novoEstado;
    }

    public EstadoPlayer getEstado() {
        return estadoAtual;
    }

    public String apertarPlay() {
        return estadoAtual.apertarPlay(this);
    }

    public String apertarPause() {
        return estadoAtual.apertarPause(this);
    }

    public String apertarStop() {
        return estadoAtual.apertarStop(this);
    }

    public String getStatus() {
        return "Faixa: " + nomeFaixa + " | Estado: " + estadoAtual.getClass().getSimpleName();
    }
}
