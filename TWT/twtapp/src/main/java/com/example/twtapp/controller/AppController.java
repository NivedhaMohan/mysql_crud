package com.example.twtapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	Bookservice bookservice;
	
	@PostMapping
	public ResponseEntity<Book>savebook(@RequestBody Book book) {
		return bookservice.addbook(book);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getbook() {
		return bookservice.getbook();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book>findbookbyid(@PathVariable long id) {
		return bookservice.getBookbyId(id);
	}
		
	@PutMapping("/{id}")
	public ResponseEntity<Book>updatebookbyid(@PathVariable long id,@RequestBody Book book) {
		return bookservice.updatebook(id, book);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletebookbyid(@PathVariable long id) {
		return bookservice.deletebook(id);
	}
	
}
