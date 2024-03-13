package co.edu.unbosque.controller;

import co.edu.unbosque.model.*;
import co.edu.unbosque.view.*;

public class Controller {
    private Model objModel;
    private View objView;

    public Controller() {
        objModel = new Model();
        objView = new View();
        funcionar();
    }

    public void funcionar() {
        objView.mostrarCancion("BIENVENIDO A EL PROGRAMA\nVamos a crear tu propia canción de reguetton.");

        int menu;
        do {
            try {
                menu = objView.mostrarMenu();
                switch (menu) {
                    case 1:
                        int numeroEstrofa = objView.pedirEstrofas();
                        int numeroFrase = objView.pedirFrases();
                        objModel.gestionarPropiedad(numeroEstrofa, numeroFrase);
                        break;

                    case 2:
                        String cancion = objModel.guardarCancion();
                        objView.mostrarCancion(cancion);
                        objModel.guardarCancionEnArchivo(cancion);
                        break;

                    case 3:
                        objView.mostrarCancion(objModel.seleccionarCancionYMostrar());
                        break;

                    case 4:
                        objView.mostrarCancion("GRACIAS POR USAR EL PROGRAMA, HASTA PRONTO!");
                        break;

                    default:
                        objView.mostrarCancion("Opción no válida");
                        break;
                }
            } catch (NumberFormatException e) {
                objView.mostrarCancion("Por favor, ingrese un número válido.");
                menu = 0; 
            }
        } while (menu != 4);
    }
}