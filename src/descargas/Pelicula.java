package descargas;

public class Pelicula extends Contenido {

	Director director;
	Actor[] actoresPrincipales;
	
	public Pelicula(Long id, String titulo) {
		super(id, titulo);
	} 
}
