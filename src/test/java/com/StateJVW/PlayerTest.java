package com.StateJVW;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private static final String FAIXA = "Trilha Sonora de TRON Legacy";

    @Test
    void deveIniciarNoEstadoParado() {
        Player player = new Player(FAIXA);
        assertInstanceOf(PlayerEstadoParado.class, player.getEstado());
        assertEquals("Faixa: Trilha Sonora de TRON Legacy | Estado: PlayerEstadoParado", player.getStatus());
    }

    @Test
    void deveRejeitarComandosInvalidosNoEstadoParado() {
        Player player = new Player(FAIXA);
        assertEquals("Comando PAUSE. Não é possível pausar se estiver parado.", player.apertarPause());
        assertEquals("Comando STOP. Já está parado.", player.apertarStop());
        assertInstanceOf(PlayerEstadoParado.class, player.getEstado());
    }

    @Test
    void deveFazerOTempoDeVidaCompletoParadoTocandoPausadoParado() {
        Player player = new Player(FAIXA);

        // 1. (PLAY)
        assertEquals("Comando PLAY. Iniciando reprodução.", player.apertarPlay());
        assertInstanceOf(PlayerEstadoTocando.class, player.getEstado());

        // 2. (PAUSE)
        assertEquals("Comando PAUSE. Reprodução suspensa.", player.apertarPause());
        assertInstanceOf(PlayerEstadoPausado.class, player.getEstado());

        // 3. (PLAY para retomar)
        assertEquals("Comando PLAY. Retomando reprodução.", player.apertarPlay());
        assertInstanceOf(PlayerEstadoTocando.class, player.getEstado());

        // 4. (STOP)
        assertEquals("Comando STOP. Reprodução encerrada e Player parado.", player.apertarStop());
        assertInstanceOf(PlayerEstadoParado.class, player.getEstado());
    }

    @Test
    void deveReagirCorretamenteNoEstadoPausado() {
        Player player = new Player(FAIXA);
        player.setEstado(new PlayerEstadoPausado());

        assertEquals("Comando PAUSE. Já está pausado.", player.apertarPause()); // Não muda
        assertEquals("Comando STOP. Reprodução encerrada e Player parado.", player.apertarStop()); // Muda
        assertInstanceOf(PlayerEstadoParado.class, player.getEstado());
    }
}