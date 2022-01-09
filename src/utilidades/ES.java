/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author felipe
 * Utilidades de entrada y salida
 */
public class ES {
    /**
     * Lee un entero desde el teclado
     * @return 
     */
    public static int leerEntero(){
    Scanner teclado = new Scanner(System.in);

        while (true) {
            try {
                return teclado.nextInt();
            } catch (InputMismatchException error) {
                System.err.println("No es un número entero. Vuelve a intentarlo.");
            }
            teclado.nextLine();
        }
    }
    
    /**
     * Lee un entero desde el teclado, presentando previamente un mensaje
     * @param mensaje
     * @return 
     */
    public static int leerEntero(String mensaje){
        escribir(mensaje);
        return leerEntero();
    }

    /**
     * Lee un número entero desde teclado, verificando que está entre un valor
     * minimo y un maximo
     *
     * @param minimo
     * @param maximo
     * @return
     */
    public static int leerEntero(int minimo, int maximo) {
        int valor;
        while(true) {
            valor = leerEntero();
            if (valor < minimo || valor > maximo){
                System.err.printf("Valor fuera de rango. Debe estar entre %d y %d. Vuelve a intentarlo.\n", minimo, maximo);
            } else {
                return valor;
            }
        }
        
    }

    /**
     * Lee un número entero por teclado, verificando que está entre minimo y
     * maximo, mostrando antes un mensaje
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @return
     */
    public static int leerEntero(int minimo, int maximo, String mensaje) {
        escribir(mensaje);
        return leerEntero(minimo, maximo);
        
    }

    /**
     * Presenta un mensaje y pide una respuesta de sí o no
     *
     * @param mensaje
     * @return true si ha respondido sí, o false si ha respondido no
     */
    public static boolean leerSiNo(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        String respuesta;

        while (true) {
            System.out.print(mensaje);
            respuesta = teclado.nextLine();
            switch (respuesta) {
                case "s":
                case "si":
                case "sí":
                    return true;
                case "n":
                case "no":
                    return false;
                default:
                    System.out.println("Debes responder sí o no (s, n)");
            }
        }
    }

    /**
     * Escribe una cadena de texto sin salto de línea
     *
     * @param mensaje
     */
    public static void escribir(String mensaje) {
        System.out.print(mensaje);
    }

    /**
     * Escribe un número en pantalla
     *
     * @param numero
     */
    public static void escribir(int numero) {
        System.out.print(numero);
    }

    /**
     * Escribe una cadena de texto con salto de línea
     *
     * @param mensaje
     */
    public static void escribirln(String mensaje) {
        System.out.println(mensaje);
    }
}
