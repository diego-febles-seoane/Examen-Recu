package es.ies.model.controller;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import es.ies.model.VideoJuego;
import es.ies.model.fichero.OperacionesFichero;

public class VideoJuegoController  {
    Set<VideoJuego> videojuegos;

    public VideoJuegoController() {

    }

    public Set<VideoJuego> obtenerVideoJuegosDespuesDe(int anio) {
        return new HashSet();
    }

    public Set<VideoJuego> obtenerVideoJuegosPorPlataforma(String plataforma) {
        return new HashSet();
    }

    public Set<VideoJuego> obtenerVideoJuegosEntreFechas(String fechaInicio, String fechaFin) {

        return new HashSet();
    }

    public Set<VideoJuego> obtenerVideoJuegosPorPalabraClave(String palabraClave) {
        return new HashSet();
    }

    public VideoJuego obtenerMasAntiguo() {
        return new VideoJuego();
    }

    public Set<VideoJuego> getVideojuegos() {
        return this.videojuegos;
    }

    public void setVideojuegos(Set<VideoJuego> videojuegos) {
        this.videojuegos = videojuegos;
    }

}
