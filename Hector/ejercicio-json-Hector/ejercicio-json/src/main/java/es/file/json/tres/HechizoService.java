package es.file.json.tres;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import es.file.json.Abstractas.FileAbstractas;

public class HechizoService extends FileAbstractas {

    ObjectMapper objectMapper;
    List<Hechizo> hechizos;
    File file;

    public HechizoService() {
        file = new File(pathTres);
        if (file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        objectMapper = new ObjectMapper();
        hechizos = loadAll();
    }

    public Hechizo findById(int id) {
        if (!fileExist(pathTres)){
            return null;
        }
        if(id < 0){
            return null;
        }
        try {
            Hechizo hechizo = new Hechizo(id);
            int position = hechizos.indexOf(hechizo);
            if(position < 0){
                return null;
            }
            return hechizos.get(position);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Hechizo> findByDateRange(String startDate, String endDate) {
        if (startDate == null || startDate.isEmpty() || endDate == null||
        endDate.isEmpty()){
            return null;
        }
        try {
            List<Hechizo> hechizoList = new ArrayList<>();
            LocalDate inicio = LocalDate.parse(startDate);
            LocalDate fin = LocalDate.parse(endDate);
            for(Hechizo hechizo : hechizos){
                LocalDate fechaHechizo = LocalDate.parse(hechizo.getFechaCreacion());
                if((fechaHechizo.isBefore(fin) || fechaHechizo.equals(fin)) &&
                (fechaHechizo.isAfter(inicio) || fechaHechizo.equals(inicio))){
                    hechizoList.add(hechizo);
                }
            }
            return new ArrayList<>(hechizoList);
        } catch (Exception e) {
            e.printStackTrace();
            return hechizos;
        }

    }

    public List<Hechizo> getList() {
        if (hechizos.isEmpty()) {
            return hechizos;
        }
        return new ArrayList<>(hechizos);
    }

    public List<Hechizo> loadAll() {
        if (!fileExist(pathTres)) {
            return hechizos;
        }
        try {
            String json = new String(Files.readAllBytes(Paths.get(pathTres)));
            Type listType = new TypeToken<ArrayList<Hechizo>>() {
            }.getType();
            hechizos = new Gson().fromJson(json, listType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return hechizos;
    }

    public boolean add(Hechizo obj) {
        if (obj == null) {
            return false;
        }
        try {
            if (hechizos.contains(obj)) {
                return false;
            }
            boolean insertar = hechizos.add(obj);
            if (insertar) {
                saveFile(hechizos);
            }
            return insertar;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Hechizo obj) {
        if (obj == null) {
            return false;
        }
        if (!hechizos.contains(obj)) {
            return false;
        }
        boolean borrar = hechizos.remove(obj);
        if (borrar) {
            saveFile(hechizos);
        }
        return borrar;
    }

    public void saveFile(List<Hechizo> hechizos) {
        try (FileWriter writer = new FileWriter(pathTres)) {
            new GsonBuilder().setPrettyPrinting().create().toJson(hechizos, writer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
