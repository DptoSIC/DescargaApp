package descargas;

import java.time.Instant;

public abstract class ContenidoImpl implements Contenido {

	private String id;
	private String titulo;
	private Instant fecha;
	
	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public String getTitulo() {
		return titulo;
	}
	
	@Override
	public Instant getFecha() {
		return fecha;
	}

	public ContenidoImpl() {
		this(null, null);
	}
	
	public ContenidoImpl(String id, String titulo) {
		this.id = id;
		this.titulo = titulo;
		fecha = Instant.now();
	}
	
	@Override
	public String toString() {
		return getTitulo();
	}
}