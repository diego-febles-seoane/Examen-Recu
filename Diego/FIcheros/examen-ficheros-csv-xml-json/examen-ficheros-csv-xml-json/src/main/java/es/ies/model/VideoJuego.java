package es.ies.model;
import java.util.Objects;


public class VideoJuego {

    private int id;
    private String nombre;
    private String plataforma;
    private String fechaLanzamiento;

    public VideoJuego() {
    }

    public VideoJuego(int id) {

    }

    public VideoJuego(int id, String nombre, String plataforma, String fechaLanzamiento) {
        
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", plataforma='" + getPlataforma() + "'" +
            ", fechaLanzamiento='" + getFechaLanzamiento() + "'" +
            "}";
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VideoJuego)) {
            return false;
        }
        VideoJuego videoJuego = (VideoJuego) o;
        return id == videoJuego.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, plataforma, fechaLanzamiento);
    }
    


    

    
    

}
