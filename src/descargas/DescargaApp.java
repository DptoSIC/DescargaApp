package descargas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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
		Conexion conexion = //new Conexion(5f, "Movistar");
							new Conexion() {
								
								@Override
								public float getVelocidadDescarga() {
									return 5f;
								}
								
							};
		System.out.println("Tiempo estimado: " + Utils.getTiempo(listaDescargas, conexion));
		
		Identificable[] identificables = { listaDescargas[0], cancion2, pelicula1 };
		for (Identificable identificable : identificables) {
			System.out.println(identificable.getId());
		}
		
		
		Collection<Fichero> listaFicheros = new ArrayList<Fichero>();// Arrays.asList(listaDescargas);
		for (int i = 0; i < listaDescargas.length; i++) {
			listaFicheros.add(listaDescargas[i]);
		}
//		listaFicheros.get(0).getId();
		listaFicheros.stream().map(Fichero::getId).forEach(System.out::println);
		listaFicheros.forEach(System.out::println);
		
		System.out.println(calcularTamanoTotal("", listaDescargas[0], listaDescargas[1], listaDescargas[1]));
	}
	
	private static float calcularTamanoTotal(String loquesea, Fichero... ficheros) {
		return Utils.getTamano(ficheros);
	}
	
	private static float calcularTamanoTotal(Collection<Fichero> ficheros) {
		float total = 0;
		for (Fichero fichero : ficheros) {
			total += fichero.getTamano();
		}
		
		return total;
	}
	
}
