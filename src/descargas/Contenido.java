package descargas;

public abstract class Contenido implements Identificable<Long>, Nombrable {

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

	public Contenido() {
	}
	
	public Contenido(Long id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}
	
	@Override
	public String toString() {
		return getTitulo();
	}
}