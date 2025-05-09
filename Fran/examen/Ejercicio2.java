package es.ies.puerto.fichero.examen;

import java.io.File;

public class Ejercicio2 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    /**
     * Metodo que comprueba si el directorio selccionado existe
     * 
     * @param nombreDirectorio el cual quereremos verificar
     * @return false si se introduce un dato incorrecto o si no es un directorio,
     *         true si es un directorio
     */
    public static boolean existeDirectorio(String nombreDirectorio) {
        if (nombreDirectorio == null || nombreDirectorio.isEmpty() || nombreDirectorio.isBlank()) {
            return false;
        }

        File directorio = new File(nombreDirectorio);
        if (!directorio.exists() || !directorio.isDirectory()) {
            return false;
        }
        return true;

    }
}