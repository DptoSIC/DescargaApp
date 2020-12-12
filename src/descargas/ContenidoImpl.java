package descargas;

public abstract class ContenidoImpl implements Contenido {

	private Long id;
	private String titulo;
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public String getTitulo() {
		return titulo;
	}

	public ContenidoImpl() {
	}
	
	public ContenidoImpl(Long id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}
	
	@Override
	public String toString() {
		return getTitulo();
	}
}