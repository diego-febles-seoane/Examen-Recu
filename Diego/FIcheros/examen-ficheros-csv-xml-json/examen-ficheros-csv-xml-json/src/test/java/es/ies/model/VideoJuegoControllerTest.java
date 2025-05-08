package es.ies.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import es.ies.model.controller.VideoJuegoController;

class VideoJuegoControllerTest {

    private VideoJuegoController videoJuegoController;


    @BeforeEach
    void beforeEach() {
        videoJuegoController = new VideoJuegoController();

        Set<VideoJuego> videojuegosMock = new HashSet<>();
        videojuegosMock.add(new VideoJuego(1, "Super Mario 64", "Nintendo", "1996-06-23"));
        videojuegosMock.add(new VideoJuego(2, "The Legend of Zelda", "Nintendo", "1986-02-21"));
        videojuegosMock.add(new VideoJuego(3, "Doom", "Nintendo", "1993-12-10"));
        videojuegosMock.add(new VideoJuego(4, "Final Fantasy VII", "PlayStation", "1997-01-31"));
        videojuegosMock.add(new VideoJuego(5, "Street Fighter II", "Xbox", "1991-02-06"));
        videojuegosMock.add(new VideoJuego(6, "Metal Gear Solid", "Pc", "1998-09-03"));
        videojuegosMock.add(new VideoJuego(7, "The Elder Scrolls V: Skyrim", "Pc", "2011-11-11"));
        videojuegosMock.add(new VideoJuego(8, "Minecraft", "Pc", "2011-11-18"));
        videojuegosMock.add(new VideoJuego(9, "Half-Life", "Xbox", "1998-11-19"));
        videojuegosMock.add(new VideoJuego(10, "The Witcher 3", "PlayStation", "2015-05-19"));

        videoJuegoController.setVideojuegos(videojuegosMock);

        
    }

    @Test
    @Order(1)
    void testObtenerTodosLosVideojuegos() {
        assertEquals(10, videoJuegoController.getVideojuegos().size(), "Deben existir 10");
    }
    

    @Test
    @Order(2)
    void testObtenerVideoJuegosDespuesDe1992() {
        
        Set<VideoJuego> resultado = videoJuegoController.obtenerVideoJuegosDespuesDe( 1992);

        assertEquals(8, resultado.size(), "Deben existir 8");
    }

    @Test
    @Order(3)
    void testObtenerVideoJuegosDespuesDe1997() {
        
        Set<VideoJuego> resultado = videoJuegoController.obtenerVideoJuegosDespuesDe( 1997);

        assertEquals(5, resultado.size(), "Deben existir 5");
    }

    @Test
    @Order(4)
    void testObtenerVideoJuegosDespuesDe2025() {
        
        Set<VideoJuego> resultado = videoJuegoController.obtenerVideoJuegosDespuesDe( 2025);

        assertEquals(0, resultado.size(), "Deben existir 0");
    }

    @Test
    @Order(4)
    void testObtenerVideoJuegosNintendo() {
        
        Set<VideoJuego> resultado = videoJuegoController.obtenerVideoJuegosPorPlataforma("Nintendo");

        assertEquals(3, resultado.size());
        Assertions.assertEquals(3, resultado.size());
        Assertions.assertTrue(resultado.toString().contains("Super Mario 64"));
        Assertions.assertTrue(resultado.toString().contains("The Legend of Zelda"));
        Assertions.assertTrue(resultado.toString().contains("Doom"));

    }

    @Test
    @Order(5)
    void testObtenerVideoJuegosPlataformaNull() {
        
        Set<VideoJuego> resultado = videoJuegoController.obtenerVideoJuegosPorPlataforma(null);
        assertEquals(0, resultado.size());
    }

    @Test
    @Order(6)
    void testObtenerVideoJuegosPlataformaEmpty() {
        
        Set<VideoJuego> resultado = videoJuegoController.obtenerVideoJuegosPorPlataforma("");
        assertEquals(0, resultado.size());
    }

    @Test
    @Order(7)
    void testObtenerVideoJuegosDesde1990Hasta1999() {
        Set<VideoJuego> resultado = videoJuegoController.obtenerVideoJuegosEntreFechas( "1990-01-01", "1999-01-01");
        assertEquals(6, resultado.size()); 
    }

    @Test
    @Order(8)
    void testObtenerVideoJuegosDesdeValoresNullos() {
        Set<VideoJuego> resultado = videoJuegoController.obtenerVideoJuegosEntreFechas( null, null);
        assertEquals(0, resultado.size()); 
    }

    @Test
    @Order(9)
    void testObtenerVideoJuegosDesdeValoresEmpty() {
        Set<VideoJuego> resultado = videoJuegoController.obtenerVideoJuegosEntreFechas( "null", "");
        assertEquals(0, resultado.size()); 
    }

    @Test
    @Order(10)
    void testObtenerVideoJuegosPorPalabraClave() {

        Set<VideoJuego> resultado = videoJuegoController.obtenerVideoJuegosPorPalabraClave( "Mario");
        assertEquals(1, resultado.size()); 
    }

    @Test
    @Order(11)
    void testObtenerVideoJuegosPorPalabraNullo() {

        Set<VideoJuego> resultado = videoJuegoController.obtenerVideoJuegosPorPalabraClave( null);
        assertEquals(0, resultado.size()); 
    }

    @Test
    @Order(12)
    void testObtenerVideoJuegosPorPalabraEmpty() {

        Set<VideoJuego> resultado = videoJuegoController.obtenerVideoJuegosPorPalabraClave("");
        assertEquals(0, resultado.size()); 
    }

    @Test
    void testObtenerMasAntiguo() {

    VideoJuego resultado = videoJuegoController.obtenerMasAntiguo();
    assertEquals("The Legend of Zelda", resultado.getNombre()); 
}
    
}
