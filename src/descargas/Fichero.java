package descargas;

public class Fichero {
	private String id;
	private String ruta;
	private Contenido contenido;
	private float tamano; //Tamaño en MB
	
	public float getTamano() {
		return tamano;
	}
	
	public Fichero(String id, String ruta, Contenido musica, float tamano) {
		super();
		this.id = id;
		this.ruta = ruta;
		this.contenido = musica;
		this.tamano = tamano;
	}
}
