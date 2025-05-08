package es.ies.model;


import es.ies.model.fichero.OperacionesFichero;

import org.junit.jupiter.api.*;
import java.io.File;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OperacionesFicheroTest {

    private static OperacionesFichero operacionesFichero;
    private static final String PATH_CSV = "src/main/resources/videojuegos.csv";

    Set<VideoJuego> videojuegosLeidos;
    

    @BeforeEach
    void beforeEach()  {
        operacionesFichero = new OperacionesFichero();
        File csvFile = new File(PATH_CSV);
        if (!csvFile.exists()) {
            Assertions.fail("El fichero csv no existe para lanzar las pruebas");
        }
        videojuegosLeidos = operacionesFichero.csvToSet();

    }

    @Test
    @Order(1)
    void csvToSetTest() {
        assertNotNull(videojuegosLeidos, "El conjunto de videojuegos leído no debe ser nulo.");
        assertEquals(10, videojuegosLeidos.size(), "El número de videojuegos leídos debe coincidir.");
        
        assertTrue(videojuegosLeidos.contains(new VideoJuego(1, "Super Mario 64", "Nintendo", "1996-06-23")),
                "El conjunto de videojuegos debería contener 'Super Mario 64'.");
        assertTrue(videojuegosLeidos.contains(new VideoJuego(2, "The Legend of Zelda", "Nintendo", "1986-02-21")),
                "El conjunto de videojuegos debería contener 'The Legend of Zelda'.");
    }

    @Test
    @Order(2)
    void csvToXmlTest() {
        boolean almacenado = operacionesFichero.setToXml(videojuegosLeidos);
        Assertions.assertTrue(almacenado, "El fichero no se ha almacenado correctamente");
    }

    @Test
    @Order(3)
    void xmlToSetTest() {
        Set<VideoJuego> loadVideoJuegos = operacionesFichero.xmlToSet();
        Assertions.assertEquals(videojuegosLeidos.size(), loadVideoJuegos.size());
    }

    @Test
    @Order(4)
    void setToJsonTest() {
        Set<VideoJuego> loadVideoJuegosXml = operacionesFichero.xmlToSet();
        operacionesFichero.setVideojuegos(loadVideoJuegosXml);
        boolean almacenado = operacionesFichero.setToJson();
        Assertions.assertTrue(almacenado, "El fichero no se ha almacenado correctamente"); 
        Set<VideoJuego> loadVideoJuegosCsv = operacionesFichero.jsonToSet();
        Assertions.assertEquals(videojuegosLeidos, loadVideoJuegosCsv);
        Assertions.assertEquals(videojuegosLeidos.size(), loadVideoJuegosCsv.size());
    }

    
}

