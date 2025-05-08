import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import es.ies.puerto.Criatura;

class Ejercicio4Test extends BaseGestionCriaturaTest{
    @Test
    void testBorrarPorId() {
        Criatura criatura = new Criatura("1", "Dragon", "Gran dragón", "Montañas", 100);
        gestionCriaturas.insertar(criatura);
        boolean resultado = gestionCriaturas.borrar("1");
        assertTrue(resultado);
    }

    @Test
    void testBorrarNoExistente() {
        boolean resultado = gestionCriaturas.borrar("999");
        assertFalse(resultado);
    }

    @Test
    void testBorrarListaVacia() {
        boolean resultado = gestionCriaturas.borrar("1");
        assertFalse(resultado);  // No hay elementos en la lista
    }

    @Test
    void testBorrarVarios() {
        Criatura criatura1 = new Criatura("1", "Dragon", "Gran dragón", "Montañas", 100);
        Criatura criatura2 = new Criatura("2", "Unicornio", "Caballo mágico", "Bosques", 80);
        gestionCriaturas.insertar(criatura1);
        gestionCriaturas.insertar(criatura2);
        boolean resultado1 = gestionCriaturas.borrar("1");
        boolean resultado2 = gestionCriaturas.borrar("2");
        assertTrue(resultado1);
        assertTrue(resultado2);
    }

    @Test
    void testBorrarListaConUnElemento() {
        Criatura criatura = new Criatura("1", "Dragon", "Gran dragón", "Montañas", 100);
        gestionCriaturas.insertar(criatura);
        boolean resultado = gestionCriaturas.borrar("1");
        assertTrue(resultado);
        assertEquals(0, gestionCriaturas.obtenerCriaturas().size());
    }
}
