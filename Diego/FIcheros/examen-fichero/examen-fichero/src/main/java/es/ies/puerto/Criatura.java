package es.ies.puerto;

import java.io.Serializable;
import java.util.Objects;

public class Criatura implements Serializable{
    private String id;
    private String nombre;
    private String descripcion;
    private String origen;
    private int fuerza;


    public Criatura(String id, String nombre, String descripcion, String origen, int fuerza) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.origen = origen;
        this.fuerza = fuerza;
    }


    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getOrigen() {
        return this.origen;
    }

    public int getFuerza() {
        return this.fuerza;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Criatura)) {
            return false;
        }
        Criatura criatura = (Criatura) o;
        return Objects.equals(id, criatura.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return id +"," + nombre + "," + descripcion + "," + origen + "," + fuerza;
    }

}