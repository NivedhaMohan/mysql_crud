package com.example.twtapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.twtapp.entity.Book;

@Repository
public interface Bookdao extends JpaRepository<Book,Long>{
	
	public Book findById(long id);
	
}
