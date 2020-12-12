package descargas;

public class Fichero<T extends Identificable<String> & Nombrable> implements Identificable<Long> {
	private Long id;
	private String ruta;
	private T contenido;
	private float tamano; //Tamano en MB
	
	
	@Override
	public Long getId() {
		return id;
	}

	public float getTamano() {
		return tamano;
	}
	
	public T getContenido() {
		return contenido;
	}
	
	public Fichero(Long id, String ruta, T contenido, float tamano) {
		super();
		this.id = id;
		this.ruta = ruta;
		this.contenido = contenido;
		this.tamano = tamano;
	}
	
	@Override
	public String toString() {
		return "#" + getId() + " - " + getContenido() + " (" + getTamano() + "MB)";
	}
}
