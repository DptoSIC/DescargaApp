package descargas;

public class DescargaApp {

	public static void main(String[] args) {
		Musica cancion1 = new Musica("1", "tituloA");
		Musica cancion2 = new Musica("2", "tituloB");
		Pelicula pelicula1 = new Pelicula("3", "tituloC");
		Fichero[] listaDescargas = {
				new Fichero("id1", null, cancion1, 15.2f),
				new Fichero("id2", null, cancion2, 14.5f)
		};
		Conexion conexion = new Conexion(5f, "Movistar");
		System.out.println("Tiempo estimado: " + Utils.getTiempo(listaDescargas, conexion));
	}
	
}
