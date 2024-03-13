package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {

    public int mostrarMenu() {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione una opción:\n1. Definir parámetros\n2. Crear canción\n3. Seleccionar canción\n4. Salir", "MENU", JOptionPane.INFORMATION_MESSAGE));
        } catch (NumberFormatException e) {
            return 0; 
        }
    }

    public int pedirEstrofas() {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el número de estrofas que desea en su canción: "));
    }

    public int pedirFrases() {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el número de frases que desea por estrofa en su canción: "));
    }

    public void mostrarCancion(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Canción", JOptionPane.INFORMATION_MESSAGE);
    }
}