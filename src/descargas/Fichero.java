package descargas;

public class Fichero {
	private String id;
	private String ruta;
	private Musica musica;
	private float tamano; //Tamaño en MB
	
	public float getTamano() {
		return tamano;
	}
	
	public Fichero(String id, String ruta, Musica musica, float tamano) {
		super();
		this.id = id;
		this.ruta = ruta;
		this.musica = musica;
		this.tamano = tamano;
	}
}
