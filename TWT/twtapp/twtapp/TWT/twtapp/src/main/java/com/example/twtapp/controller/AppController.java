package com.example.twtapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.twtapp.entity.Book;
import com.example.twtapp.service.Bookservice;

@RestController
@RequestMapping("/book")
public class AppController {
	
	@Autowired
	private Bookservice bookservice;
	
	@PostMapping
	public Book savebook(@RequestBody Book book) {
		return bookservice.addbook(book);
		
	}
	
	@GetMapping
	public List<Book> getbook() {
		return bookservice.getbook();
	}
	
	@GetMapping("/{id}")
	public Book findbookbyid(@PathVariable int id) {
		return bookservice.getBookbyId(id);
	}
		
	@PutMapping("/{id}")
	public Book updatebookbyid(@PathVariable int id,@RequestBody Book book) {
		return bookservice.updatebook(id, book);
	}

	@DeleteMapping("/{id}")
	public void deletebookbyid(@PathVariable int id) {
		bookservice.deletebook(id);
	}
	
}
