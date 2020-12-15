package com.github;

import java.time.LocalDate;

public class Book {
	String isbn;
	String title;
	LocalDate date = LocalDate.now();
	
	public String getIsbn() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public LocalDate getDate() {
		return date;
	}

	public Book(String isbn, String title) {
		super();
		this.isbn = isbn;
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "(" + getIsbn() +  ") " + getTitle();
	}
}
