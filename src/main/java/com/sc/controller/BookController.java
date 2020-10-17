package com.sc.controller;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sc.service.Book;
import com.sc.service.BookService;
import com.sc.service.BookUser;

@RestController
@RequestMapping(value="/web")
public class BookController 
{
	
	  @Autowired 
	  BookService service;
	  @Autowired
	  BookUser user;
	  
	  @RequestMapping("/books") 
	  public Book insertBook(Book book) throws SQLException 
	  { 
		  return service.createBook(book); 
	  }
	 
	@RequestMapping(value="/booklist")
	public List<Book> getBooks()
	{
		return user.getAllBooks();
	}
}
