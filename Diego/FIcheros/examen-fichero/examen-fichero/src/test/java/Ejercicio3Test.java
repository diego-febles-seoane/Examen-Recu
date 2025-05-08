import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import es.ies.puerto.Criatura;

class Ejercicio3Test extends BaseGestionCriaturaTest{
    
    @Test
    void testInsertarCriatura() {
        Criatura criatura = new Criatura("1", "Dragon", "Gran dragón", "Montañas", 100);
        boolean resultado = gestionCriaturas.insertar(criatura);
        assertTrue(resultado);
    }

    @Test
    void testInsertarVariosCriaturas() {
        Criatura criatura1 = new Criatura("1", "Dragon", "Gran dragón", "Montañas", 100);
        Criatura criatura2 = new Criatura("2", "Unicornio", "Caballo mágico", "Bosques", 80);
        boolean resultado1 = gestionCriaturas.insertar(criatura1);
        boolean resultado2 = gestionCriaturas.insertar(criatura2);
        assertTrue(resultado1);
        assertTrue(resultado2);
    }

    @Test
    void testInsertarDuplicados() {
        Criatura criatura1 = new Criatura("1", "Dragon", "Gran dragón", "Montañas", 100);
        Criatura criatura2 = new Criatura("1", "Dragon", "Gran dragón", "Montañas", 100); 
        boolean resultado1 = gestionCriaturas.insertar(criatura1);
        boolean resultado2 = gestionCriaturas.insertar(criatura2);
        assertTrue(resultado1);
        assertFalse(resultado2);
    }

    @Test
    void testInsertarNull() {
        boolean resultado = gestionCriaturas.insertar(null);
        assertFalse(resultado);
    }

    @Test
    void testInsertarVerificarLista() {
        Criatura criatura = new Criatura("1", "Dragon", "Gran dragón", "Montañas", 100);
        gestionCriaturas.insertar(criatura);
        assertEquals(1, gestionCriaturas.obtenerCriaturas().size());
    }
}
