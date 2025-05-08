import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import es.ies.puerto.fichero.examen.Ejercicio1;

class Ejercicio1Test {

    @Test
    void testNombreFicheroNulo() {
        assertFalse(Ejercicio1.existeFichero(null), "Debe devolver false si el nombre es nulo.");
    }

    @Test
    void testNombreFicheroVacio() {
        assertFalse(Ejercicio1.existeFichero(""), "Debe devolver false si el nombre está vacío.");
    }

    @Test
    void testNombreFicheroSoloEspacios() {
        assertFalse(Ejercicio1.existeFichero("   "), "Debe devolver false si el nombre tiene solo espacios.");
    }

    @Test
    void testFicheroInexistente() {
        assertFalse(Ejercicio1.existeFichero("archivo_inexistente.txt"), "Debe devolver false si el fichero no existe.");
    }

    @Test
    void testFicheroExistente() throws IOException {
        String nombreFichero = "src/main/resources/archivo_temporal.txt";
        File fichero = new File(nombreFichero);
        fichero.createNewFile(); 

        assertTrue(Ejercicio1.existeFichero(nombreFichero), "Debe devolver true si el fichero existe.");

        fichero.delete(); 
    }


    @Test
    void testNombreCaracteresEspeciales() {
        assertFalse(Ejercicio1.existeFichero("<>:?*|\".txt"), "Debe devolver false para nombres inválidos.");
    }

    @Test
    void testFicheroEnUbicacionIncorrecta() {
        assertFalse(Ejercicio1.existeFichero("archivo_fuera.txt"), "Debe devolver false si el fichero no está en el directorio actual.");
    }
}
