/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverraya;

/**
 *
 * @author VICTUS hp
 */
public final class Raya {
    private final char[][] tablero;
    private char jugadorActual;
    private boolean juegoTerminado;
    private char ganador;
    
    public static final char JUGADOR_X = 'X';
    public static final char JUGADOR_O = 'O';
    public static final char VACIO = ' ';
    
    public Raya() {
        tablero = new char[3][3];
        inicializarJuego();
    }

    public static char getVACIO() {
        return VACIO;
    }
    
    public void inicializarJuego() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = VACIO;
            }
        }
        jugadorActual = JUGADOR_X;
        juegoTerminado = false;
        ganador = VACIO;
    }
    
    public boolean hacerMovimiento(int fila, int columna) {
        if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
            return false;
        }
        
        if (tablero[fila][columna] != VACIO || juegoTerminado) {
            return false;
        }
        
        tablero[fila][columna] = jugadorActual;
        verificarEstadoJuego();
        
        if (!juegoTerminado) {
            jugadorActual = (jugadorActual == JUGADOR_X) ? JUGADOR_O : JUGADOR_X;
        }
        
        return true;
    }
    
    private void verificarEstadoJuego() {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2] && tablero[i][0] != VACIO) {
                ganador = tablero[i][0];
                juegoTerminado = true;
                return;
            }
        }
        
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == tablero[1][j] && tablero[1][j] == tablero[2][j] && tablero[0][j] != VACIO) {
                ganador = tablero[0][j];
                juegoTerminado = true;
                return;
            }
        }
        
        if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[0][0] != VACIO) {
            ganador = tablero[0][0];
            juegoTerminado = true;
            return;
        }
        
        if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0] && tablero[0][2] != VACIO) {
            ganador = tablero[0][2];
            juegoTerminado = true;
            return;
        }
        
        boolean tableroLleno = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == VACIO) {
                    tableroLleno = false;
                    break;
                }
            }
            if (!tableroLleno) break;
        }
        
        if (tableroLleno) {
            juegoTerminado = true;
            ganador = VACIO;
        }
    }
    
    public char obtenerCasilla(int fila, int columna) {
        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3) {
            return tablero[fila][columna];
        }
        return VACIO;
    }
    
    public char obtenerJugadorActual() {
        return jugadorActual;
    }
    
    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }
    
    public char obtenerGanador() {
        return ganador;
    }
    
    public boolean isEmpate() {
        return juegoTerminado && ganador == VACIO;
    }
    
    public String obtenerTableroString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n   0   1   2\n");
        for (int i = 0; i < 3; i++) {
            sb.append(i).append("  ");
            for (int j = 0; j < 3; j++) {
                sb.append(tablero[i][j]);
                if (j < 2) sb.append(" | ");
            }
            sb.append("\n");
            if (i < 2) sb.append("  -----------\n");
        }
        return sb.toString();
    }
    
    public void reiniciarJuego() {
        inicializarJuego();
    }
}
