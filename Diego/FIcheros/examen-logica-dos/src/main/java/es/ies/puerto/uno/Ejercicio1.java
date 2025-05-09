package es.ies.puerto.uno;

import java.util.Scanner;

/**
 * Ejercicio 1: Comprobar si una palabra o frase es un palindromo.
 * @author jpexpsito
 * @apiNote Hay otras solucines para el ejercicio, como la utilización de StringBuilder y la comparación de caracteres en lugar de char[], entre otras.
 */
public class Ejercicio1 {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Introduce una palabra o frase:");
    String texto = scanner.nextLine().toLowerCase();

    char[] caracteres = texto.toCharArray();

    int izquierda = 0;
        int derecha = caracteres.length - 1;

        // Comparar los caracteres desde los extremos hacia el centro
        while (izquierda < derecha) {
            if (caracteres[izquierda] != caracteres[derecha]) {
                System.out.println("No es un palíndromo.");
                break;
            }
            izquierda++;
            derecha--;
        }
        System.out.println("Es un palíndromo.");


    }
}