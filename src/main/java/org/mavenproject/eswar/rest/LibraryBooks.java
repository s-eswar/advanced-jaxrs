package org.mavenproject.eswar.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LibraryBooks {
private Map<Long, Book> books = Databaseclass.getBooks();
	
	public LibraryBooks() {
		
	}
	
	public List<Book> getAllBooks(){
		return new ArrayList<Book>(books.values());
	}
	
	public Book getBook(Long id) {
		return books.get(id);
	}
	
	public Book addBook(Book book) {
		book.setId(books.size()+1);
		books.put(Long.valueOf(book.getId()), book);
		return book;
	}
	
	public Book removeBook(Long id) {
		return books.remove(id);
	}
	public Book updateBook(Book book) {
		if(book.getId()<=0) {
			return null;
		}
		else {
			books.put(Long.valueOf(book.getId()),book);
			return book;
		}
	}
}
