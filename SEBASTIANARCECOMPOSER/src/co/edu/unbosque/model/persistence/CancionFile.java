package co.edu.unbosque.model.persistence;

import java.io.*;

public class CancionFile {

    private String archivoCancion;

    public CancionFile(String archivoCancion) {
        this.archivoCancion = archivoCancion;
    }

    public boolean escribirArchivo(String song) {
        File f = new File(this.archivoCancion);

        try {
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(song);

            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public String leerArchivo() {
        StringBuilder cancion = new StringBuilder();
        String linea = "";

        File f = new File(this.archivoCancion);

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            linea = br.readLine();
            while (linea != null) {
                cancion.append(linea).append("\n");
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return cancion.toString();
    }
}