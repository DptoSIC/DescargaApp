package descargas;

public abstract class ContenidoImpl implements Contenido {

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

	public ContenidoImpl() {
	}
	
	public ContenidoImpl(String id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}
	
	@Override
	public String toString() {
		return getTitulo();
	}
}