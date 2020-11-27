package descargas;

public abstract class Contenido implements Identificable, Nombrable {

	private String id;
	private String titulo;
	
	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public String getTitulo() {
		return titulo;
	}

	public Contenido() {
	}
	
	public Contenido(String id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}
	
}