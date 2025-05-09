package es.ies.puerto.file.uno;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileXmlCriatura {

    /**
     * Metodo para obtener las criaturas de una lista
     * @return
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public List<Criatura> obtenerCriaturas() throws IOException, SAXException, ParserConfigurationException {
        List<Criatura> criaturas = new ArrayList<>();
        File archivo = new File("src/main/resources/uno.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(archivo);
        NodeList lista = doc.getElementsByTagName("criatura");
        for (int i = 0; i < lista.getLength(); i++) {
            Node nodo = lista.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo;
                String id = elemento.getElementsByTagName("id").item(0).getTextContent();
                String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                String descripcion = elemento.getElementsByTagName("Descripcion").item(0).getTextContent();
                String categoria = elemento.getElementsByTagName("categoria").item(0).getTextContent();
                criaturas.add(new Criatura(id, nombre, descripcion, categoria));
            }
        }
        return criaturas;
    }

    /**
     * Metodo para obtener una criatura por su id
     * @param id
     * @return
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public Criatura obtener(Criatura id) throws SAXException, IOException, ParserConfigurationException{
        if(id == null){
            return null;
        }
        List<Criatura> criaturas = obtenerCriaturas();
        for (Criatura criatura : criaturas) {
            if(criatura.equals(id)){
                return criatura;
            }
        }
        return null;
    }

    /**
     * Metodo para añadir una criatura al fichero
     * @param criatura
     * @return
     * @throws Exception
     */
    public boolean addCriatura(Criatura criatura) throws Exception {
        List<Criatura> criaturas = obtenerCriaturas();
        if (criatura == null) {
            return false;
        }
        if (!criaturas.contains(criatura)){
            criaturas.add(criatura);
            volcarFicheroXml(criaturas);
            return true;
        }
        return false;
    }

    /**
     * Metodo para borrar una criatura del fichero
     * @param criatura
     */
    public boolean deleteCriatura(Criatura criatura) throws Exception {
        List<Criatura> criaturas = obtenerCriaturas();
        if(criatura == null){
            return false;
        }
        if (!criaturas.contains(criatura)){
            return false;
        }
        criaturas.remove(criatura);
        volcarFicheroXml(criaturas);
        return true;
    }

    /**
     * Metodo para actualizar una criatura del fichero
     * @param criaturaActualizada
     * @throws Exception
     */
    public void updateCriatura(Criatura criaturaActualizada) throws Exception {
        List<Criatura> criaturas = obtenerCriaturas();
        int posicion = criaturas.indexOf(criaturaActualizada);
        if(posicion > 0){
            criaturas.set(posicion ,criaturaActualizada);
            volcarFicheroXml(criaturas);
        }
    }

    /**
     * Metodo para volcar el fichero
     * @param criaturas
     * @throws Exception
     */
    public static void volcarFicheroXml(List<Criatura> criaturas) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element root = doc.createElement("criaturas");
        doc.appendChild(root);

        for (Criatura criatura : criaturas) {
            Element criaturaXml = doc.createElement("criatura");
            root.appendChild(criaturaXml);

        Element id = doc.createElement("id");
        id.appendChild(doc.createTextNode(criatura.getId()));
        criaturaXml.appendChild(id);

        Element nombreXml = doc.createElement("nombre");
        nombreXml.appendChild(doc.createTextNode(criatura.getNombre()));
        criaturaXml.appendChild(nombreXml);

        Element descripcionXml = doc.createElement("Descripcion");
        descripcionXml.appendChild(doc.createTextNode(criatura.getDescripcion()));
        criaturaXml.appendChild(descripcionXml);

        Element categoriaXml = doc.createElement("categoria");
        categoriaXml.appendChild(doc.createTextNode(criatura.getCategoria()));
        criaturaXml.appendChild(categoriaXml);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/main/resources/uno.xml"));
        transformer.transform(source, result);
    }
}
