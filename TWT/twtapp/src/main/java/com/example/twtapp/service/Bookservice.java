package com.example.twtapp.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.twtapp.dao.Bookdao;
import com.example.twtapp.entity.Book;

@Service
public class Bookservice {
	
	@Autowired
	Bookdao bookdao;
	
	public ResponseEntity<Book> addbook(Book book) {
		try {
				Book bookdata = bookdao.save(book);
				return new ResponseEntity<>(bookdata,HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		
	}	  
	
	public ResponseEntity<List<Book>> getbook() {
		try {
			    List<Book> book=bookdao.findAll();
			    if(book.isEmpty()) {
			    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }
			    return new ResponseEntity<>(book,HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public ResponseEntity<Book>getBookbyId(long id) {
		try{
			Book book=bookdao.findById(id);
			if(book != null) {
				return new ResponseEntity<>(book,HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
		
	public ResponseEntity<Book> updatebook(long id,Book book) {
		try {
			Book bookdata =bookdao.findById(id);
			bookdata.setId(id);
			bookdata.setName(book.getName());
			bookdata.setAuthor(book.getAuthor());
			bookdata.setPrice(book.getPrice());
			return new ResponseEntity<>(bookdao.save(bookdata),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
   public ResponseEntity<String> deletebook(long id) {
	   try {
		   bookdao.deleteById(id);
		   return new ResponseEntity<>("The record deleted successfully",HttpStatus.OK);
	   }catch(Exception e) {
		   return new ResponseEntity<>("Error in deleting the record",HttpStatus.NOT_FOUND);
   }
  }
}

