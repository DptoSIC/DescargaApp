package descargas;

import com.github.Book;

public class Libro extends Book implements Contenido {

	Long id;
	
	public Libro(String isbn, String title) {
		super(isbn, title);
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getTitulo() {
		return getTitle();
	}

}
