/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

import configuracion.DatosPrograma;
import utilidades.ES;

/**
 *
 * @author felipe Juego LIGHTS OUT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    private static boolean[][] tablero;

    public static void main(String[] args) {
        int opcion;
        do {
            menu();
            opcion = ES.leerEntero(0, 3, "Elija una opción: ");
            switch (opcion) {
                case 1:
                    utilidades.ES.escribirln("Esta opción no está disponible.");
                    break;
                case 2:
                    jugar(true); // Niveles
                    break;
                case 3:
                    jugar(false); // Aleatorio
                    break;
            }
        } while (opcion != 0);
    }

    /**
     * Imprime un menú y devuelve la selección del usuario
     *
     * @return el número seleccionado por el usuario
     */
    private static void menu() {
        utilidades.ES.escribirln("");
        utilidades.ES.escribirln("LIGHTS OUT");
        utilidades.ES.escribirln("==========");
        utilidades.ES.escribirln("1. Records.");
        utilidades.ES.escribirln("2. Niveles.");
        utilidades.ES.escribirln("3. Niveles aleatorios.");
        utilidades.ES.escribirln("0. Salir.");
    }

    /**
     * Inicializa el tablero con el nivel seleccionado
     *
     * @param nivel entre el 1 y el 4
     */
    private static void rellenarTablero(int nivel) {
        tablero = new boolean[DatosPrograma.TAM_TABLERO][DatosPrograma.TAM_TABLERO];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = DatosPrograma.niveles[nivel - 1][i][j];
            }
        }
    }

    /**
     * Inicializa el tablero con hasta 4 luces en posiciones aleatorias
     */
    private static void rellenarTableroAleatorio() {
        tablero = new boolean[DatosPrograma.TAM_TABLERO][DatosPrograma.TAM_TABLERO];
        int i, j;
        int fila, columna;

        for (i = 0; i < tablero.length; i++) {
            for (j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = false;
            }
        }
        for (i = 0; i < DatosPrograma.CELDAS_MAX_INI_ALEATORIO; i++) {
            fila = (int) (Math.random() * DatosPrograma.TAM_TABLERO);
            columna = (int) (Math.random() * DatosPrograma.TAM_TABLERO);
            tablero[fila][columna] = true;
        }
    }

    /**
     * Muestra el tablero
     */
    private static void mostrarTablero() {
        ES.escribirln("  1 2 3 4 5");
        for (int i = 0; i < DatosPrograma.TAM_TABLERO; i++) {
            ES.escribir(i + 1);
            for (int j = 0; j < DatosPrograma.TAM_TABLERO; j++) {
                ES.escribir(" " + (tablero[i][j] ? DatosPrograma.L_ENCENDIDA : DatosPrograma.L_APAGADA));
            }
            ES.escribirln("");
        }
    }

    /**
     * Comprueba si todas la luces del tablero están apagadas
     *
     * @return true si están todas apagadas; false en caso contrario.
     */
    private static boolean comprobarTodasApagadas() {
        boolean encontradaEncendida = false;

        for (int i = 0; i < DatosPrograma.TAM_TABLERO && !encontradaEncendida; i++) {
            for (int j = 0; j < DatosPrograma.TAM_TABLERO && !encontradaEncendida; j++) {
                encontradaEncendida = tablero[i][j];
            }
        }
        return !encontradaEncendida;
    }

    /**
     * Modificar las luces según las reglas del juego, para un elección de fila
     * y columna
     *
     * @param fila
     * @param columna
     */
    private static void modificarLuces(int fila, int columna) {
        if (fila > 0) {
            tablero[fila - 1][columna] = !tablero[fila - 1][columna];
        }
        if (fila < DatosPrograma.TAM_TABLERO - 1) {
            tablero[fila + 1][columna] = !tablero[fila + 1][columna];
        }
        if (columna > 0) {
            tablero[fila][columna - 1] = !tablero[fila][columna - 1];
        }
        if (columna < DatosPrograma.TAM_TABLERO - 1) {
            tablero[fila][columna + 1] = !tablero[fila][columna + 1];
        }
        tablero[fila][columna] = !tablero[fila][columna];
    }

    /**
     * Jugar una partida
     *
     * @param tipo Puede ser false o true, según el tipo de partida false
     * significa aleatorio true significa por niveles
     */
    private static void jugar(boolean tipo) {
        int jugadasRestantes;
        int puntuacion = 0;
        int nivel = 1;
        boolean seguimosJugando = true;

        // Esto es una serie de partidas
        while (seguimosJugando) {
            if (tipo) { // Niveles
                jugadasRestantes = DatosPrograma.MOV_MAX_NIVEL;
                rellenarTablero(nivel);
            } else { // Aleatorio
                jugadasRestantes = DatosPrograma.MOV_MAX_ALEATORIO;
                rellenarTableroAleatorio();
            }

            ES.escribirln("");
            ES.escribirln("Iniciamos una nueva partida");
            if (tipo) { // Niveles
                ES.escribirln("Este es el nivel " + nivel);
            }

            // Esto es una partida, es decir, una serie de jugadas
            while (seguimosJugando && jugadasRestantes > 0 && !comprobarTodasApagadas()) {
                mostrarTablero();
                if (jugadasRestantes == 1) {
                    ES.escribirln("Te queda 1 jugada");
                } else {
                    ES.escribirln("Te quedan " + jugadasRestantes + " jugadas");
                }
                int fila = ES.leerEntero(1, DatosPrograma.TAM_TABLERO, "Selecciona la fila: ") - 1;
                int columna = ES.leerEntero(1, DatosPrograma.TAM_TABLERO, "Selecciona la columna: ") - 1;
                modificarLuces(fila, columna);
                jugadasRestantes--;
                if (comprobarTodasApagadas()) {
                    mostrarTablero();
                    ES.escribirln("¡Has ganado! No sé cómo lo has hecho...");
                    if (tipo) { // Niveles
                        puntuacion += DatosPrograma.PUNTUACION_MAXIMA / (DatosPrograma.MOV_MAX_NIVEL - jugadasRestantes);
                        if (nivel < 4) {
                            nivel++;
                            ES.escribirln("Llevas " + puntuacion + " puntos acumulados.");
                        } else { // Hemos terminado el último nivel
                            seguimosJugando = false;
                            ES.escribirln("Has conseguido un total de " + puntuacion + " puntos.");
                        }
                    } else { // Modo aleatorio
                        puntuacion += DatosPrograma.PUNTUACION_MAXIMA / (DatosPrograma.MOV_MAX_ALEATORIO - jugadasRestantes);
                        ES.escribirln("Has conseguido un total de " + puntuacion + " puntos.");
                    }
                }

                if (jugadasRestantes == 0) {
                    if (tipo) { // Niveles
                        if (ES.leerSiNo("¿Quieres abandonar el juego? (s/n): ")) {
                            seguimosJugando = false;
                            ES.escribirln("Has conseguido un total de " + puntuacion + " puntos.");
                        }
                    } else {
                        seguimosJugando = false;
                        ES.escribirln("Has perdido. No sabes lo que haces XD");
                        ES.escribirln("Has conseguido un total de " + puntuacion + " puntos.");
                    }
                }
            }
        }
    }
}
