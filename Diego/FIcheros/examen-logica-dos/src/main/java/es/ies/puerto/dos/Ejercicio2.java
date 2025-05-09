package es.ies.puerto.dos;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una lista de números separados por comas:");
        String input = scanner.nextLine();
        String[] numerosStr = input.split(",");
        //TODO:PODEMOS UTILIZAR DIRECTAMENTE LOS ARRAY INDICANDO SU VALOR EN numerosStr
        int mayor = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;

        for (String numStr : numerosStr) {
            int num = Integer.parseInt(numStr.trim());
            if (num > mayor) mayor = num;
            if (num < menor) menor = num;
        }

        System.out.println("El número mayor es " + mayor + " y el número menor es " + menor);
        scanner.close();
    }
}