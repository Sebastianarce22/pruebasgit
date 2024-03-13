package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.Properties;

public class CancionPropiedades {

    private Properties prop = new Properties();
    private String archivoprop = "C:\\data\\cancion.properties";

    public int escribirPropiedades(int numeroEstrofa, int numeroFrase) {
        try {
            prop.setProperty("Numero de estrofas", String.valueOf(numeroEstrofa));
            prop.setProperty("Numero de frases por estrofa", String.valueOf(numeroFrase));
            prop.store(new FileOutputStream(archivoprop), null);
        } catch (IOException ex) {
            ex.printStackTrace();
            return -1;
        }
        return 0;
    }

    public Properties cargarPropiedades() {
        try (FileInputStream input = new FileInputStream(archivoprop)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public String obtenerPropiedad(String clave) {
        return prop.getProperty(clave);
    }

    public void establecerPropiedad(String clave, String valor) {
        prop.setProperty(clave, valor);
    }

}