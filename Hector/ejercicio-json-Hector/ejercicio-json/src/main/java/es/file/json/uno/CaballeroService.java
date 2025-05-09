package es.file.json.uno;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

public final class CaballeroService extends FileAbstractas {

    ObjectMapper objectMapper;
    List<Caballero> caballeros;
    File file;

    public CaballeroService() {
        file = new File(pathUno);
        if (file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        objectMapper = new ObjectMapper();
        caballeros = loadAll();
    }

    public Caballero findById(int id) {
        if (!fileExist(pathUno)) {
            return null;
        }
        if (id < 0) {
            return null;
        }
        try {
            Caballero caballero = new Caballero(id);
            int position = caballeros.indexOf(caballero);
            if (position < 0) {
                return null;
            }
            return caballeros.get(position);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Caballero> findByDateRange(String startDate, String endDate) {
        if (startDate == null || startDate.isEmpty() || endDate == null ||
                endDate.isEmpty()) {
            return null;
        }
        try {
            List<Caballero> caballeroList = new ArrayList<>();
        LocalDate inico = LocalDate.parse(startDate);
        LocalDate fin = LocalDate.parse(endDate);
        for (Caballero caballero : caballeros) {
            LocalDate fechaCaballero = LocalDate.parse(caballero.getFechaIngreso());
            if ((fechaCaballero.isBefore(fin) || fechaCaballero.equals(fin))
                    && (fechaCaballero.isAfter(inico) || fechaCaballero.equals(inico))) {
                caballeroList.add(caballero);
            }
        }
        return new ArrayList<>(caballeroList);
        } catch (Exception e) {
            e.printStackTrace();
            return caballeros;
        }
    }

    public List<Caballero> getList() {
        if (caballeros.isEmpty()) {
            return caballeros;
        }
        return new ArrayList<>(caballeros);
    }

    public List<Caballero> loadAll() {
        if (!fileExist(pathUno)) {
            return caballeros;
        }
        try {
            String json = new String(Files.readAllBytes(Paths.get(pathUno)));
            Type listType = new TypeToken<ArrayList<Caballero>>() {
            }.getType();
            caballeros = new Gson().fromJson(json, listType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return caballeros;
    }

    public boolean add(Caballero obj) {
        if (obj == null) {
            return false;
        }
        try {
            if (caballeros.contains(obj)) {
            return false;
        }
        boolean insertar = caballeros.add(obj);
        if (insertar) {
            saveFile(caballeros);
        }
        return insertar;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Caballero obj) {
        if (obj == null) {
            return false;
        }
        if (!caballeros.contains(obj)) {
            return false;
        }
        boolean borrar = caballeros.remove(obj);
        if (borrar) {
            saveFile(caballeros);
        }
        return borrar;
    }

    public void saveFile(List<Caballero> caballeros) {
        try (FileWriter writer = new FileWriter(pathUno)) {
            new GsonBuilder().setPrettyPrinting().create().toJson(caballeros, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
