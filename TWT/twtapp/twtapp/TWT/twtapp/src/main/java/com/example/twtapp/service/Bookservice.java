package com.example.twtapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.twtapp.dao.Bookdao;
import com.example.twtapp.entity.Book;

@Service
public class Bookservice {
	
	@Autowired
	private Bookdao bookdao;
	
	public Book addbook(Book book) {
		return bookdao.save(book);
	}
	
	public List<Book> getbook() {
		return bookdao.findAll();
	}
	
	public Book getBookbyId(int id) {
		return bookdao.findById(id);
	}
	
	public Book updatebook(int id,Book book) {
		Book bookdata = getBookbyId(id);
		bookdata.setId(id);
		bookdata.setName(book.getName());
		bookdata.setAuthor(book.getAuthor());
		bookdata.setPrice(book.getPrice());
		return bookdao.save(bookdata);
		}
	
   public void deletebook(int id) {
	   bookdao.deleteById(id);
	   
   }
}

