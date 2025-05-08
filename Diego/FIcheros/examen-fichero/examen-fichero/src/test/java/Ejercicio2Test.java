import org.junit.jupiter.api.Test;

import es.ies.puerto.fichero.examen.Ejercicio2;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

class Ejercicio2Test {

    @Test
    void testNombreDirectorioNulo() {
        assertFalse(Ejercicio2.existeDirectorio(null), "Debe devolver false si el nombre es nulo.");
    }

    @Test
    void testNombreDirectorioVacio() {
        assertFalse(Ejercicio2.existeDirectorio(""), "Debe devolver false si el nombre está vacío.");
    }

    @Test
    void testNombreDirectorioSoloEspacios() {
        assertFalse(Ejercicio2.existeDirectorio("   "), "Debe devolver false si el nombre tiene solo espacios.");
    }

    @Test
    void testDirectorioInexistente() {
        assertFalse(Ejercicio2.existeDirectorio("directorio_inexistente"), "Debe devolver false si el directorio no existe.");
    }

    @Test
    void testDirectorioExistente() {
        String nombreDirectorio = "src/main/java/es/ies/puerto/fichero/examen"; 
        File directorio = new File(nombreDirectorio);
        assertTrue(directorio.exists() && directorio.isDirectory(), "Debe ser un directorio existente.");
        assertTrue(Ejercicio2.existeDirectorio(nombreDirectorio), "Debe devolver true si el directorio existe.");
    }

    @Test
    void testNombreEsArchivoNoDirectorio() {
        String nombreArchivo = "pom.xml"; 
        File archivo = new File(nombreArchivo);
        assertTrue(archivo.exists() && archivo.isFile(), "Debe ser un archivo, no un directorio.");
        assertFalse(Ejercicio2.existeDirectorio(nombreArchivo), "Debe devolver false si es un archivo y no un directorio.");
    }

    @Test
    void testNombreCaracteresEspeciales() {
        assertFalse(Ejercicio2.existeDirectorio("<>:?*|\""), "Debe devolver false para nombres inválidos.");
    }

    @Test
    void testDirectorioEnUbicacionIncorrecta() {
        assertFalse(Ejercicio2.existeDirectorio("otro_directorio"), "Debe devolver false si el directorio no está en la ubicación esperada.");
    }
}

