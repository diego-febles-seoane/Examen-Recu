package es.ies.puerto.file.tres;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileArmasCsv {

    File file = new File("src/main/resources/tres.csv");

    /**
     * Metodo para obtener la lista de armas
     */
    public List<Arma> obtenerArmas() {
        List<Arma> armas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arrayLine = line.split(",");
                int longitud = arrayLine.length;
                String descripcionArchivo = line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\""));
                Arma arma = new Arma(arrayLine[0], arrayLine[1], descripcionArchivo, arrayLine[longitud - 2],
                        Integer.parseInt(arrayLine[longitud - 1]));
                armas.add(arma);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return armas;
    }

    /**
     * Metodo para obtener una arma en especifico
     * @param arma
     */
    public Arma obtenerArma(Arma arma) {
        if (arma == null) {
            return null;
        }
        List<Arma> armas = obtenerArmas();
        int posicion = armas.indexOf(arma);
        if (posicion < 0) {
            return null;
        }
        return armas.get(posicion);
    }

    /**
     * Metodo para actualizar el fichero 
     * @param data
     * @return
     */
    public boolean actualizarFichero(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(data);
            writer.newLine();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Metodo para añadir un arma al fichero
     * @param arma
     */
    public void addArma(Arma arma) {
        List<Arma> armas = obtenerArmas();
        if (arma != null) {
            armas.add(arma);
            actualizarFichero(arma.toString());
            }
        }

        /**
         * Metodo para borrar un arma del fichero
         * @param arma
         */
    public void deleteArma(Arma arma) {
        List<Arma> armas = obtenerArmas();
        if (arma != null) {
            armas.remove(arma);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (Arma arma2 : armas) {
                    writer.write(arma2.toString());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metodo para actualizar la informacion de un arma
     * @param arma
     */
    public void updateArma(Arma arma) {
        List<Arma> armas = obtenerArmas();
        int posicion = armas.indexOf(arma);
        if (arma != null && posicion >= 0) {
            armas.set(posicion, arma);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (Arma arma2 : armas) {
                    writer.write(arma2.toString());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
