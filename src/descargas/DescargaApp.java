package descargas;

import java.util.Arrays;

public class DescargaApp {

	public static void main(String[] args) {
		Contenido cancion1 = new Musica("1", "tituloA");
		Contenido cancion2 = new Musica("2", "tituloB");
		Contenido pelicula1 = new Pelicula("3", "tituloC");
		Fichero[] listaDescargas = {
				new Fichero("id1", null, cancion1, 15.2f),
				new Fichero("id2", null, cancion2, 14.5f),
				new Fichero("id3", null, pelicula1, 104.5f)
		};
		Conexion conexion = new Conexion(5f, "Movistar");
		System.out.println("Tiempo estimado: " + Utils.getTiempo(listaDescargas, conexion));
		
		Identificable[] identificables = { listaDescargas[0], cancion2, pelicula1 };
		for (Identificable identificable : identificables) {
			System.out.println(identificable.getId());
		}
		
	}
	
}
