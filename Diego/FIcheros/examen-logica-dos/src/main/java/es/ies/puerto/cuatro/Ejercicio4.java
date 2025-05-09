package es.ies.puerto.cuatro;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una oración:");
        String oracion = scanner.nextLine().trim();
        String[] palabras = oracion.split(" ");
        
        System.out.println("La oración tiene " + palabras.length + " palabras.");
        scanner.close();
    }
}