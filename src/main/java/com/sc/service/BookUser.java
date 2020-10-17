package com.sc.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.dao.BookDao;


@Service 
public class BookUser implements BookService
{
		@Autowired
		BookDao dao;
		

		public Book createBook(Book book) throws SQLException
		{
			
			return dao.insertBook(book);
		}
	
		public List<Book> getAllBooks()
		{
			return dao.getAllBooks();
		}

}
