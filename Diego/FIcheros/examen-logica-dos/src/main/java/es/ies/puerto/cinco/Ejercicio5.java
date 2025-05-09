package es.ies.puerto.cinco;

import java.util.Scanner;
/**
 * Ejercicio 5: Juego de adivinar un numero
 * aleatorio.
 * @author jpexpsito
 * @apiNote Hay otras soluciones para el ejercicio,
 *  como la utilizacion de un bucle while y un contador
 *  de intentos, entre otras.
 */
public class Ejercicio5 {
        public static void main(String[] args) {
        int numeroAleatorio = (int) (Math.random() * 100) + 1;
        Scanner scanner = new Scanner(System.in);
        int intento = 0;
        int intentosRestantes = 3;
        
        while (intentosRestantes > 0) {
            System.out.println("Adivina el número entre 1 y 100. Te quedan " + intentosRestantes + " intentos:");
            intento = scanner.nextInt();
            intentosRestantes--;
            
            if (intento < numeroAleatorio) {
                System.out.println("El número es mayor.");
            } else if (intento > numeroAleatorio) {
                System.out.println("El número es menor.");
            } else {
                System.out.println("¡Felicidades! Adivinaste el número.");
                break;
            }
        }
        
        if (intento != numeroAleatorio) {
            System.out.println("Lo siento, no adivinaste el número. El número era " + numeroAleatorio);
        }
        
        scanner.close();
    }
}