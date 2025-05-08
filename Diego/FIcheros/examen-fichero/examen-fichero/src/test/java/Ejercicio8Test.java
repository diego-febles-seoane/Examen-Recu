import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import es.ies.puerto.Criatura;
import es.ies.puerto.fichero.examen.GestionCriaturas;

class Ejercicio8Test extends BaseGestionCriaturaTest{
    
    @Test
    void testBuscarPorNombre_CasoNombreExistente() {
        GestionCriaturas gestion = new GestionCriaturas();

        gestion.insertar(new Criatura("1", "Dragon", "Un dragón feroz", "Montañas", 100));

        List<Criatura> resultado = gestion.buscarPorNombre("Dragon");

        assertEquals(1, resultado.size());
        assertEquals("Dragon", resultado.get(0).getNombre());
    }

    @Test
    void testBuscarPorNombre_CasoNombreDuplicado() {
        GestionCriaturas gestion = new GestionCriaturas();

        gestion.insertar(new Criatura("1", "Dragon", "Un dragón feroz", "Montañas", 100));
        gestion.insertar(new Criatura("2", "Dragon", "Un dragón amigable", "Valle", 60));

        List<Criatura> resultado = gestion.buscarPorNombre("Dragon");

        assertEquals(2, resultado.size());
        for (Criatura criatura : resultado) {
            assertEquals("Dragon", criatura.getNombre());
        }
    }

    @Test
    void testBuscarPorNombre_CasoNoExistente() {
        GestionCriaturas gestion = new GestionCriaturas();

        List<Criatura> resultado = gestion.buscarPorNombre("Fenix");

        assertEquals(0, resultado.size());
    }

    @Test
    void testBuscarPorNombre_CasoCaseInsensitive() {
        GestionCriaturas gestion = new GestionCriaturas();

        gestion.insertar(new Criatura("1", "Dragon", "Un dragón feroz", "Montañas", 100));

        List<Criatura> resultado = gestion.buscarPorNombre("dragon");

        assertEquals(1, resultado.size());
        assertEquals("Dragon", resultado.get(0).getNombre());
    }

    @Test
    void testBuscarPorNombre_CasoListaVacia() {
        GestionCriaturas gestion = new GestionCriaturas();

        List<Criatura> resultado = gestion.buscarPorNombre("Dragon");

        assertEquals(0, resultado.size());
    }
}
