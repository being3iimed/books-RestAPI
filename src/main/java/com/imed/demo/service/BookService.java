package com.imed.demo.service;
import java.util.*;
import com.imed.demo.domain.*;
public interface BookService {
	
	Collection<Book> findAll();
	Book findById(Long id);
	Book save(Book book);
	Book update(Book book);
	Book deleteById(Long id);

}
