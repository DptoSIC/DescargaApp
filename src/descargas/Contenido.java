package descargas;

public interface Contenido extends Identificable<Long>, Nombrable {

	Long getId();
	String getTitulo();

}