/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuracion;

/**
 *
 * @author felipe
 * Estos son los parámetros del juego,recogidos en un solo lugar
 */
public class DatosPrograma {

    public static final int TAM_TABLERO = 5;
    public static final int MOV_MAX_NIVEL = 25;
    public static final int MOV_MAX_ALEATORIO = 50;
    public static final int PUNTUACION_MAXIMA = 10000;
    public static final int CELDAS_MAX_INI_ALEATORIO = 4;
    public static final String L_ENCENDIDA = "\u001b[33m●\u001B[0m";
    public static final String L_APAGADA = "\u001b[37m●\u001B[0m";
    public static boolean[][][] niveles = {
        {
            {false, false, false, false, false},
            {false, false, false, false, false},
            {true, false, true, false, true},
            {false, false, false, false, false},
            {false, false, false, false, false}
        },
        {
            {true, false, true, false, true},
            {true, false, true, false, true},
            {false, false, false, false, false},
            {true, false, true, false, true},
            {true, false, true, false, true}
        },
        {
            {false, true, false, true, false},
            {true, true, false, true, true},
            {true, true, false, true, true},
            {true, true, false, true, true},
            {false, true, false, true, false}
        },
        {
            {false, false, false, false, false},
            {true, true, false, true, true},
            {false, false, false, false, false},
            {true, false, false, false, true},
            {true, true, false, true, true}
        }
    };
}
