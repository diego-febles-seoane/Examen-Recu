import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import es.ies.puerto.Criatura;

class Ejercicio7Test extends BaseGestionCriaturaTest{
    
    @Test
    void testBuscarPorId() {
        Criatura criatura = new Criatura("1", "Dragon", "Gran dragón", "Montañas", 100);
        gestionCriaturas.insertar(criatura);
        Criatura encontrada = gestionCriaturas.buscar("1");
        assertNotNull(encontrada);
        assertEquals("Dragon", encontrada.getNombre());
    }

    @Test
    void testBuscarPorIdNoExistente() {
        Criatura encontrada = gestionCriaturas.buscar("999");
        assertNull(encontrada);
    }

    @Test
    void testBuscarListaVacia() {
        Criatura encontrada = gestionCriaturas.buscar("1");
        assertNull(encontrada); 
    }
    
}
