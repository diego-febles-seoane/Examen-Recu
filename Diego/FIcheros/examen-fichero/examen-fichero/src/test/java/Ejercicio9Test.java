import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import es.ies.puerto.Criatura;
import es.ies.puerto.fichero.examen.GestionCriaturas;

class Ejercicio9Test extends BaseGestionCriaturaTest{
    
    @Test
    void testBuscarPorOrigen_CasoOrigenExistente() {
        GestionCriaturas gestion = new GestionCriaturas();

        gestion.insertar(new Criatura("1", "Dragon", "Un dragón feroz", "Montañas", 100));

        List<Criatura> resultado = gestion.buscarPorOrigen("Montañas");

        assertEquals(1, resultado.size());
        assertEquals("Montañas", resultado.get(0).getOrigen());
    }

    @Test
    void testBuscarPorOrigen_CasoOrigenDuplicado() {
        GestionCriaturas gestion = new GestionCriaturas();

        // Insertamos varias criaturas con origen "Montañas"
        gestion.insertar(new Criatura("1", "Dragon", "Un dragón feroz", "Montañas", 100));
        gestion.insertar(new Criatura("2", "Troll", "Un troll de las cavernas", "Montañas", 70));

        List<Criatura> resultado = gestion.buscarPorOrigen("Montañas");

        assertEquals(2, resultado.size());
        for (Criatura criatura : resultado) {
            assertEquals("Montañas", criatura.getOrigen());
        }
    }

    @Test
    void testBuscarPorOrigen_CasoNoExistente() {
        GestionCriaturas gestion = new GestionCriaturas();

        List<Criatura> resultado = gestion.buscarPorOrigen("Océano");

        assertEquals(0, resultado.size());
    }

    @Test
    void testBuscarPorOrigen_CasoCaseInsensitive() {
        GestionCriaturas gestion = new GestionCriaturas();

        // Insertamos una criatura con origen "Montañas"
        gestion.insertar(new Criatura("1", "Dragon", "Un dragón feroz", "Montañas", 100));

        List<Criatura> resultado = gestion.buscarPorOrigen("montañas");

        assertEquals(1, resultado.size());
        assertEquals("Montañas", resultado.get(0).getOrigen());
    }

    @Test
    void testBuscarPorOrigen_CasoListaVacia() {
        GestionCriaturas gestion = new GestionCriaturas();

        List<Criatura> resultado = gestion.buscarPorOrigen("Montañas");
        assertEquals(0, resultado.size());
    }
}
