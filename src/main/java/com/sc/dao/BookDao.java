package com.sc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.sc.service.Book;
@Repository
public class BookDao 
{
	List<Book> books;
	Connection con;
	
	public BookDao() throws ClassNotFoundException 
	{
		super();
		
		
			books=new ArrayList<Book>();
			books.add(new Book(1,"Like It Happened Yesterday","Biopic",600));
			books.add(new Book(2,"Last Breath","Horror",400));
			books.add(new Book(3,"Notebook","Romantic",300));
		
	}
	//Please Insert a different Id every time before running the program.As Id is a primary key it will not hold any duplicate value.
	public Book insertBook(Book book) throws SQLException
	{
		try 
		{
			con=DbConnector.getConnection();
			String query=("insert into springbook values(?,?,?,?)");
			PreparedStatement ps =con.prepareStatement(query);	
			ps.setInt(1,5);
			ps.setString(2,"abc");
			ps.setString(3,"xyz");
			ps.setDouble(4, 500);
			ps.executeUpdate();
			PreparedStatement ps1=con.prepareStatement("Select * from springbook");
            ResultSet users1=ps1.executeQuery();
                while(users1.next())
                {
                    System.out.println(+users1.getInt(1) +","+users1.getString(2)+","+users1.getString(3)+","+users1.getInt(4));
                }
			return book;
		}
	
			finally
		{
			con.close();
		}
	}
	public List<Book> getAllBooks() 
	{
			
		return books;
		
	}
	
}
		

		