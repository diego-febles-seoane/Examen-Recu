package es.ies.puerto.fichero.examen;

import java.io.File;

public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    String direccion = "examen-fichero/examen-fichero/src";

    /**
     * Metodo que verifica si existe un fichero
     * 
     * @param nombreFichero el cual queremos comprobar
     * @return false si insertamos un dato en el metodo que no sera correcto (null,
     *         vacio y con espacios), true si el archivo se ha comprobado
     *         correctamente
     */
    public static boolean existeFichero(String nombreFichero) {
        if (nombreFichero == null || nombreFichero.isEmpty() || nombreFichero.isBlank()) {
            return false;
        }
        File fichero = new File(nombreFichero);

        if (!fichero.exists()) {
            return false;
        }
        return true;
    }
}