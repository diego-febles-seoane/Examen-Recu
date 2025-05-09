package es.ies.puerto.fichero.examen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import es.ies.puerto.Criatura;

public class FileOperations {

    public static void create(String data, File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(data);
            writer.newLine();
            System.out.println("Registro agregado.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " +
                    e.getMessage());
        }
    }

    public static Map<String,Criatura> read(File file) {
        Map<String, Criatura> criaturas = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    Criatura criatura = new Criatura(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]));
                    criaturas.put(criatura.getId(), criatura);
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " +
                    e.getMessage());
        }
        return criaturas;
    }
    
    public static boolean write(Map<String, Criatura> criaturas, File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            for (Criatura criatura : criaturas.values()) {
                writer.write(criatura.toString());
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
            return false;
        }
    }
}
