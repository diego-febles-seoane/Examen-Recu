package es.file.json.Abstractas;

import java.io.File;

public class FileAbstractas {
    public static final String pathUno = "src/main/resources/caballeros.json";
    public static final String pathDos = "src/main/resources/tributos.json";
    public static final String pathTres = "src/main/resources/hechizos.json";

    public boolean fileExist(String path){
        if (path == null || path.isEmpty()){
            return false;
        }
        File file = new File(path);
        return file.exists() && file.isFile();
    }
}
