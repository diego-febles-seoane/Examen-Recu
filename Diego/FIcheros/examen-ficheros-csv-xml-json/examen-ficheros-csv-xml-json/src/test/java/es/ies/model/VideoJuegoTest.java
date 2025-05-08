package es.ies.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VideoJuegoTest {

    private VideoJuego juego1;
    private VideoJuego juego2;
    private VideoJuego juego3;

    @BeforeEach
    void beforeEach() {
        juego1 = new VideoJuego(1, "Super Mario 64", "Nintendo","1996-06-23");
        juego2 = new VideoJuego(1, "Super Mario 64", "Plataformas", "1996-06-23"); 
        juego3 = new VideoJuego(2, "The Legend of Zelda", "Aventura","1986-02-21");
    }

    @Test
    void constructorSinParametrosTest() {
        VideoJuego juego = new VideoJuego();
        assertNotNull(juego);
    }

    @Test
    void constructorConIdTest() {
        VideoJuego juego = new VideoJuego(10);
        assertEquals(10, juego.getId());
    }

    @Test
    void xonstructorCompletoTest() {
        assertEquals(1, juego1.getId());
        assertEquals("Super Mario 64", juego1.getNombre());
        assertEquals("Nintendo", juego1.getPlataforma());
        assertEquals("1996-06-23", juego1.getFechaLanzamiento());
    }

    @Test
    void equalsMismoObjetoTest() {
        assertEquals(juego1, juego1);
    }

    @Test
    void equalsObjetosIgualesTest() {
        assertEquals(juego1, juego2);
    }

    @Test
    void equalsObjetosDiferentesTest() {
        assertNotEquals(juego1, juego3);
    }
    @Test
    void equalsObjetosTiposDiferentesTest() {
        String juego4 = "soy un juego";
        boolean resultado = juego1.equals(juego4);
        assertFalse(resultado);
    }

    @Test
    void hashCodeIgualesTest() {
        assertEquals(juego1.hashCode(), juego2.hashCode());
    }

    @Test
    void hashCodeDiferentesTest() {
        assertNotEquals(juego1.hashCode(), juego3.hashCode());
    }

    @Test
    void testToString() {
        String esperado = "1,Super Mario 64,Nintendo,1996-06-23";
        assertEquals(esperado, juego1.toString());
    }

}
