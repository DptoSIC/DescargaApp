package descargas;

public interface Contenido<T extends Comparable<T>> extends Identificable<T>, Nombrable {

	T getId();
	String getTitulo();
	
	@Override
	default String getNombre() {
		return getTitulo();
	}
}