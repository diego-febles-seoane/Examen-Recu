package es.ies.puerto.fichero.examen;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.ies.puerto.Criatura;

public class GestionCriaturas extends FileOperations {

    private File fichero;
    private List<Criatura> listaCriaturas;
    private final String FICHERO_PATH = "src/main/resources/criaturas.txt";

    public GestionCriaturas() {
        this.fichero = new File(FICHERO_PATH);
        if (!fichero.exists()) {
            try {
                fichero.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
            }
        }
        this.listaCriaturas = new ArrayList<>();
        cargarCriaturas();
    }

    private void cargarCriaturas() {
        Map<String, Criatura> mapaCriaturas = read(fichero);
        listaCriaturas = new ArrayList<>(mapaCriaturas.values());
    }

    public boolean insertar(Criatura criatura) {
        if (criatura == null) {
            return false;
        }
        
        Map<String, Criatura> criaturas = read(fichero);
        if (criaturas.containsKey(criatura.getId())) {
            return false;
        }
        
        criaturas.put(criatura.getId(), criatura);
        boolean resultado = write(criaturas, fichero);
        if (resultado) {
            cargarCriaturas();
        }
        return resultado;
    }

    public boolean borrar(String id) {
        if (id == null) {
            return false;
        }
        
        Map<String, Criatura> criaturas = read(fichero);
        if (!criaturas.containsKey(id)) {
            return false;
        }
        
        criaturas.remove(id);
        boolean resultado = write(criaturas, fichero);
        if (resultado) {
            cargarCriaturas();
        }
        return resultado;
    }

    public List<Criatura> obtenerCriaturas() {
        cargarCriaturas();
        return listaCriaturas;
    }

    public void modificar(Criatura nuevaModificada) {
        if (nuevaModificada == null) {
            return;
        }
        
        Map<String, Criatura> criaturas = read(fichero);
        if (!criaturas.containsKey(nuevaModificada.getId())) {
            return;
        }
        
        criaturas.put(nuevaModificada.getId(), nuevaModificada);
        write(criaturas, fichero);
        cargarCriaturas();
    }

    public Criatura buscar(String id) {
        if (id == null) {
            return null;
        }
        
        Map<String, Criatura> criaturas = read(fichero);
        return criaturas.get(id);
    }

    public List<Criatura> buscarPorNombre(String nombre) {
        if (nombre == null) {
            return new ArrayList<>();
        }
        
        List<Criatura> resultado = new ArrayList<>();
        cargarCriaturas();
        
        for (Criatura criatura : listaCriaturas) {
            if (criatura.getNombre() != null && 
                criatura.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
                resultado.add(criatura);
            }
        }
        
        return resultado;
    }

    public List<Criatura> buscarPorOrigen(String origen) {
        if (origen == null) {
            return new ArrayList<>();
        }
        
        List<Criatura> resultado = new ArrayList<>();
        cargarCriaturas();
        
        for (Criatura criatura : listaCriaturas) {
            if (criatura.getOrigen() != null && 
                criatura.getOrigen().toLowerCase().equals(origen.toLowerCase())) {
                resultado.add(criatura);
            }
        }
        
        return resultado;
    }
}
