package es.file.json.uno;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Caballero {
    private int id;
    private String nombre;
    private String constelacion;
    private int nivel;
    private String fechaIngreso;

    @JsonCreator
    public Caballero(@JsonProperty("id") int id,
                     @JsonProperty("nombre") String nombre,
                     @JsonProperty("constelacion") String constelacion,
                     @JsonProperty("nivel") int nivel,
                     @JsonProperty("fechaIngreso") String fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.constelacion = constelacion;
        this.nivel = nivel;
        this.fechaIngreso = fechaIngreso;
    }


    public Caballero(@JsonProperty("id") int id) {
        this.id = id;
    }
    

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getConstelacion() {
        return this.constelacion;
    }

    public int getNivel() {
        return this.nivel;
    }

    public String getFechaIngreso() {
        return this.fechaIngreso;
    }

    public Caballero() {
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setConstelacion(String constelacion) {
        this.constelacion = constelacion;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Caballero id(int id) {
        setId(id);
        return this;
    }

    public Caballero nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Caballero constelacion(String constelacion) {
        setConstelacion(constelacion);
        return this;
    }

    public Caballero nivel(int nivel) {
        setNivel(nivel);
        return this;
    }

    public Caballero fechaIngreso(String fechaIngreso) {
        setFechaIngreso(fechaIngreso);
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", constelacion='" + getConstelacion() + "'" +
            ", nivel='" + getNivel() + "'" +
            ", fechaIngreso='" + getFechaIngreso() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Caballero)) {
            return false;
        }
        Caballero caballero = (Caballero) o;
        return Objects.equals(id, caballero.id);
    }
   
}
