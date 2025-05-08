package es.ies.model.fichero;

import es.ies.model.VideoJuego;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.w3c.dom.Node;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class OperacionesFichero {

    final String pathCsv = "src/main/resources/videojuegos.csv";
    final String pathXml = "src/main/resources/videojuegos.xml";
    final String pathJson = "src/main/resources/videojuegos.json";
    Set<VideoJuego> videojuegos;

    public OperacionesFichero() {
        
    }

    public Set<VideoJuego> jsonToSet() {
        return new HashSet();
    }

    public boolean setToJson() {
        return false;
    }

    public Set<VideoJuego> xmlToSet() {
        return new HashSet();
    }

    public boolean setToXml(Set<VideoJuego> videojuegos) {
        return false;
    }

    public Set<VideoJuego> csvToSet() {
        return new HashSet();
    }


    public Set<VideoJuego> getVideojuegos() {
        return this.videojuegos;
    }

    public void setVideojuegos(Set<VideoJuego> videojuegos) {
        this.videojuegos = videojuegos;
    }

}
