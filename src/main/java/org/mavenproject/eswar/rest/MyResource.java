package org.mavenproject.eswar.rest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/test")
public class MyResource {
	
	LibraryBooks bookList = new LibraryBooks();

	@GET
	@Path("/{dateString}")
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod(@PathParam("dateString") MyDate myDate) {
		return "Date is  "+ myDate.toString();
	}
	
	@GET
	@Path("/test1")
	@Produces(MediaType.TEXT_PLAIN)
	public Date testMethod2() {
		return Calendar.getInstance().getTime();
	}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBooks(){
		return bookList.getAllBooks();
	}
	
	@GET
	@Path("/json/{bookid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBook(@PathParam("bookid") Long id) {
		return bookList.getBook(id);
	}
	
	@POST
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Book postJson(Book book) {
		bookList.updateBook(book);
		return book;
	}
	
	@PUT
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Book puttJson(Book book) {
		bookList.addBook(book);
		return book;
	}
	
	
	@DELETE
	@Path("/json/{bookid}")
	public void removebook(@PathParam("bookid") Long id) {
		 bookList.removeBook(id);
	}
	
	@PUT
	@Path("/json/{bookid}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Book updatebook(@PathParam("bookid") Long id, Book book) {
		book.setId(id.intValue());
		return bookList.updateBook(book);
	}
	
}
