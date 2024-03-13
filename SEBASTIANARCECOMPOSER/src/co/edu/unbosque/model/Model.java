package co.edu.unbosque.model;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JFileChooser;

import co.edu.unbosque.model.persistence.CancionFile;
import co.edu.unbosque.model.persistence.CancionPropiedades;

public class Model {
    JFileChooser fileChooser = new JFileChooser();
    private GenerarCancion cancion = new GenerarCancion();

    public String gestionarArchivoCadena(int numeroEstrofa, int numeroFrase) {
        CancionFile archivo = new CancionFile("c:\\data\\cancion.txt");
        String song = cancion.crearCancion(numeroEstrofa, numeroFrase);
        archivo.escribirArchivo(song);
        return archivo.leerArchivo();
    }

    public void gestionarPropiedad(int numeroEstrofa, int numeroFrase) {
        CancionPropiedades prop = new CancionPropiedades();
        prop.escribirPropiedades(numeroEstrofa, numeroFrase);
    }

    public String guardarCancion() {
        CancionPropiedades propiedad = new CancionPropiedades();
        Properties props = propiedad.cargarPropiedades();
        String cancion;

        if (props != null) {
            int numeroEstrofa = Integer.parseInt(props.getProperty("Numero de estrofas"));
            int numeroFrase = Integer.parseInt(props.getProperty("Numero de frases por estrofa"));

            cancion = gestionarArchivoCadena(numeroEstrofa, numeroFrase);

            return cancion;
        } else {
            return "Error prueba definir primero los parametros";
        }
    }

    public void guardarCancionEnArchivo(String cancion) {
        int seleccion = fileChooser.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            CancionFile archivo = new CancionFile(file.getAbsolutePath());
            gestionarArchivoGuardarCancion(cancion, archivo);
        }
    }

    public String seleccionarCancionYMostrar() {
        int seleccion = fileChooser.showOpenDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            CancionFile archivo = new CancionFile(file.getAbsolutePath());
            String cancion = leerCancionDesdeArchivo(archivo);
            return cancion;
        }
        return null;
    }

    private void gestionarArchivoGuardarCancion(String cancion, CancionFile archivo) {
        archivo.escribirArchivo(cancion);
    }

    private String leerCancionDesdeArchivo(CancionFile archivo) {
        return archivo.leerArchivo();
    }
}