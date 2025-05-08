import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import es.ies.puerto.fichero.examen.GestionCriaturas;

public abstract class BaseGestionCriaturaTest {
    
    public GestionCriaturas gestionCriaturas;
    private static final String RUTA_FICHERO = "src/main/resources/criaturas.txt";

    @BeforeEach
    public void setup() {
        try {
            File fichero = new File(RUTA_FICHERO);
            if (!fichero.exists()) {
                fichero.createNewFile();
            }
            gestionCriaturas = new GestionCriaturas();
        } catch (IOException e) {
            e.printStackTrace();
            fail("No se pudo crear el archivo para la prueba");
        }
    }

    @AfterEach
    public void cleanUp() {
        // Eliminar el fichero después de cada prueba
        File fichero = new File(RUTA_FICHERO);
        if (fichero.exists()) {
            fichero.delete();
        }
    }
}
