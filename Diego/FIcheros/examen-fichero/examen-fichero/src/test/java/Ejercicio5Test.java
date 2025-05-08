import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import es.ies.puerto.Criatura;

class Ejercicio5Test extends BaseGestionCriaturaTest{
    
    @Test
    public void testObtenerCriaturas() {
        Criatura criatura1 = new Criatura("1", "Dragon", "Gran dragón", "Montañas", 100);
        Criatura criatura2 = new Criatura("2", "Unicornio", "Caballo mágico", "Bosques", 80);
        gestionCriaturas.insertar(criatura1);
        gestionCriaturas.insertar(criatura2);
        assertEquals(2, gestionCriaturas.obtenerCriaturas().size());
    }

    @Test
    public void testObtenerListaVacia() {
        assertEquals(0, gestionCriaturas.obtenerCriaturas().size());
    }

    @Test
    public void testObtenerSoloUnElemento() {
        Criatura criatura = new Criatura("1", "Dragon", "Gran dragón", "Montañas", 100);
        gestionCriaturas.insertar(criatura);
        assertEquals(1, gestionCriaturas.obtenerCriaturas().size());
    }

    @Test
    public void testObtenerElementosDespuesDeBorrar() {
        Criatura criatura1 = new Criatura("1", "Dragon", "Gran dragón", "Montañas", 100);
        Criatura criatura2 = new Criatura("2", "Unicornio", "Caballo mágico", "Bosques", 80);
        gestionCriaturas.insertar(criatura1);
        gestionCriaturas.insertar(criatura2);
        gestionCriaturas.borrar("1");
        assertEquals(1, gestionCriaturas.obtenerCriaturas().size());
    }

}
