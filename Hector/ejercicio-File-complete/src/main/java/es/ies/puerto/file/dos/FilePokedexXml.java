package es.ies.puerto.file.dos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FilePokedexXml {
    //NO DAR FORMATO BAJO NINGUNA CIRCUNSTANCIA

    /**
     * Metodo para obtener la lista de pokemons
     * @return
     * @throws Exception
     */
    public static List<Pokemon> obtenerPokemons() throws Exception {
        List<Pokemon> pokemones = new ArrayList<>();
        File archivo = new File("src/main/resources/dos.xml");
        if(!archivo.exists()){
            return null;
        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(archivo);
        NodeList lista = doc.getElementsByTagName("pokemon");
        for (int i = 0; i < lista.getLength(); i++) {
            Node nodo = lista.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo;
                String id = elemento.getElementsByTagName("id").item(0).getTextContent();
                String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                String descripcion = elemento.getElementsByTagName("descripcion").item(0).getTextContent();

                List<String> tipos = new ArrayList<>();
                NodeList tiposLista = elemento.getElementsByTagName("tipo");
                for (int j = 0; j < tiposLista.getLength(); j++) {
                    tipos.add(tiposLista.item(j).getTextContent());
                }
                pokemones.add(new Pokemon(id, nombre, tipos, descripcion));
            }
        }
        return pokemones;
    }

    /**
     * Metodo para obtener un pokemon del fichero
     * @param pokemon
     * @return
     * @throws Exception
     */
    public Pokemon obtenerPokemon(Pokemon pokemon) throws Exception {
        if(pokemon == null){
            return null;
        }
        List<Pokemon> pokemones = obtenerPokemons();
        for (Pokemon pokemon1 : pokemones) {
            if(pokemon1.equals(pokemon)){
                return pokemon1;
            }
        }
        return null;
    }

    /**
     * Metodo para añadir un pokemon al fichero
     * @param pokemon
     * @return
     * @throws Exception
     */
    public boolean  addPokemon(Pokemon pokemon) throws Exception{
        if(pokemon == null){
            return false;
        }
        List<Pokemon> pokemones = obtenerPokemons();
        if (!pokemones.contains(pokemon)){
            pokemones.add(pokemon);
            volcarFicheroXml(pokemones);
            return true;
        }
        return false;
    }

    /**
     * Metodo para borrar un pokemon del fichero
     * @param pokemon
     * @return
     * @throws Exception
     */
    public boolean deletePokemon(Pokemon pokemon) throws Exception {
    List<Pokemon> pokemones = obtenerPokemons();
        if(pokemon == null){
            return false;
        }
        if (!pokemones.contains(pokemon)){
            return false;
        }
        pokemones.remove(pokemon);
        volcarFicheroXml(pokemones);
        return true;
    }

    /**
     * Metodo para actualizar un pokemon del fichero
     * @param pokemon
     * @throws Exception
     */
    public void updatePokemon(Pokemon pokemon) throws Exception {
    List<Pokemon> pokemones = obtenerPokemons();
        int posicion = pokemones.indexOf(pokemon);
        if(posicion > 0){
            pokemones.set(posicion ,pokemon);
            volcarFicheroXml(pokemones);
        }
    }

    /**
     * Metodo para volcar el fichero
     * @param pokemones
     * @throws Exception
     */
    public static void volcarFicheroXml(List<Pokemon> pokemones) throws Exception{

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element root = doc.createElement("pokemones");
        doc.appendChild(root);

        for (Pokemon pokemon : pokemones) {
            Element pokemonXml = doc.createElement("pokemon");
            root.appendChild(pokemonXml);

        Element id = doc.createElement("id");
        id.appendChild(doc.createTextNode(pokemon.getId()));
        pokemonXml.appendChild(id);

        Element nombreXml = doc.createElement("nombre");
        nombreXml.appendChild(doc.createTextNode(pokemon.getNombre()));
        pokemonXml.appendChild(nombreXml);

        Element tiposXml = doc.createElement("tipos");
        pokemonXml.appendChild(tiposXml);
        for (String pokemonLista : pokemon.getTipos()) {
            Element elementosTiposXml = doc.createElement("tipo");
            elementosTiposXml.appendChild(doc.createTextNode(pokemonLista));
            tiposXml.appendChild(elementosTiposXml);
        }

        Element descripcionXml = doc.createElement("descripcion");
        descripcionXml.appendChild(doc.createTextNode(pokemon.getDescripcion()));
        pokemonXml.appendChild(descripcionXml);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/main/resources/dos.xml"));
        transformer.transform(source, result);
    }

}
