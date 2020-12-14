package descargas;

public class Fichero<T extends Identificable<String> & Nombrable> implements Identificable<Long> {
	private Long id;
	private String ruta;
	private T contenido;
	private float tamano; //Tamano en MB
	private boolean premium = true;
	
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
	
	public boolean isPremium() {
		return premium;
	}
	
	public void setPremium(boolean premium) {
		this.premium = premium;
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
		return ((isPremium()) ? "*" : "")
			+ "#" + getId() + " - " + getContenido() + " (" + getTamano() + "MB)";
	}
}
