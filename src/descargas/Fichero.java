package descargas;

public class Fichero implements Identificable {
	private String id;
	private String ruta;
	private Contenido contenido;
	private float tamano; //Tamano en MB
	
	
	@Override
	public String getId() {
		return id;
	}

	public float getTamano() {
		return tamano;
	}
	
	public Contenido getContenido() {
		return contenido;
	}
	
	public Fichero(String id, String ruta, Contenido contenido, float tamano) {
		super();
		this.id = id;
		this.ruta = ruta;
		this.contenido = contenido;
		this.tamano = tamano;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "#" + getId() + " - " + getContenido() + " (" + getTamano() + "MB)";
	}
}
