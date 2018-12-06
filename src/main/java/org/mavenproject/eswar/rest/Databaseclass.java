package org.mavenproject.eswar.rest;

import java.util.HashMap;
import java.util.Map;

public class Databaseclass {
	
	private static Map<Long, Book> books= new HashMap<>();

	public static Map<Long, Book> getBooks(){
		return books;
	}
	static {
		books.put(1L, new Book("I","you",1));
		books.put(2L, new Book("me","me",2));
	}

}
