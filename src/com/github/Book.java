package com.github;

public class Book {
	String isbn;
	String title;
	
	public String getIsbn() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
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
