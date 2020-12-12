package descargas;

import com.github.Book;

public class Libro extends Book implements Contenido {
	
	public Libro(String isbn, String title) {
		super(isbn, title);
	}

	@Override
	public String getId() {
		return getIsbn();
	}

	@Override
	public String getTitulo() {
		return getTitle();
	}

}
