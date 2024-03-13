package co.edu.unbosque.model;
import java.util.*;

public class GenerarCancion {
	private String[] palabras1 = {"MAMI", "BEBE", "PRINCESS", "MOR"};
    private String[] palabras2 = {"YO QUIERO", "YO PUEDO", "YO VENGO A", "YO VOY A"};
    private String[] palabras3 = {"ENCENDELTE", "AMALTE", "LIGALTE", "JUGAL"};
    private String[] palabras4 = {"SUAVE", "LENTO", "RÁPIDO", "FUERTE"};
    private String[] palabras5 = {"HASTA SALGA EL SOL", "TODA LA NOCHE", "HASTA EL AMANECER", "TODO EL DÍA"};
    private String[] palabras6 = {"SIN ANESTESIA", "SIN COMPROMISO", "FEIS TO FEIS", "SIN MIEDO"};
    
	public String crearEstrofa() {
		Random random = new Random();
		return palabras1[random.nextInt(palabras1.length)] + " " +
				palabras2[random.nextInt(palabras1.length)] + " " +
				palabras3[random.nextInt(palabras1.length)] + " " +
				palabras4[random.nextInt(palabras1.length)] + " " +
				palabras5[random.nextInt(palabras1.length)] + " " +
				palabras6[random.nextInt(palabras1.length)];
	}
	public String crearCancion(int numeroEstrofa, int numeroFrase) {
		String cancion = "";
		for (int i = 0; i < numeroEstrofa; i++) {
			for(int j = 0; j < numeroFrase; j++) {
				String fraseAleatoria = crearEstrofa();
				cancion += fraseAleatoria + "\n";
			}
			
			cancion += "\n";
		}
		
		return cancion;
	}

}
