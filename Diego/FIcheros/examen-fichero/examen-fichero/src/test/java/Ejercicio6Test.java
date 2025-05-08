import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import es.ies.puerto.Criatura;

class Ejercicio6Test extends BaseGestionCriaturaTest{
    
    @Test
    void testModificarCriatura() {
        Criatura criatura = new Criatura("1", "Dragon", "Gran dragón", "Montañas", 100);
        gestionCriaturas.insertar(criatura);
        Criatura nuevaCriatura = new Criatura("1", "Dragon Rojo", "Dragón feroz", "Volcanes", 150);
        gestionCriaturas.modificar(nuevaCriatura);
        Criatura modificada = gestionCriaturas.buscar("1");
        assertEquals("Dragon Rojo", modificada.getNombre());
        assertEquals(150, modificada.getFuerza());
    }

    @Test
    void testModificarNoExistente() {
        Criatura criatura = new Criatura("999", "Dragon", "Gran dragón", "Montañas", 100);
        gestionCriaturas.modificar(criatura);  // ID no existe
        assertNull(gestionCriaturas.buscar("999"));
    }

    @Test
    void testModificarListaVacia() {
        Criatura criatura = new Criatura("1", "Dragon", "Gran dragón", "Montañas", 100);
        gestionCriaturas.modificar(criatura);  // Lista vacía
        assertNull(gestionCriaturas.buscar("1"));
    }
    
}
