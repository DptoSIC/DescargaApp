package descargas;

public interface Contenido extends Identificable<String>, Nombrable {

	String getId();
	String getTitulo();

}