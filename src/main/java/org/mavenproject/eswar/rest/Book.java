package org.mavenproject.eswar.rest;

public class Book {
	
	private String author;
	private String name;
	private int id;
	
	public Book() {
		
	}
	
	public Book(String author, String name,int id) {
		super();
		this.author=author;
		this.name=name;
		this.id=id;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
