package descargas;

public class Pelicula extends ContenidoImpl {

	Director director;
	Actor[] actoresPrincipales;
	
	public Pelicula(String id, String titulo) {
		super(id, titulo);
	} 
}
