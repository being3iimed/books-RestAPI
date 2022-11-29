package com.imed.demo.service.impl;
import com.imed.demo.domain.Book;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.imed.demo.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	private Long BookId = 100L;
	private  Map<Long, Book> bookMap = new HashMap<Long, Book>();
	
	{
		Book book = new Book();
		book.setId(BookId);
		book.setTitle("Grokking Algorithms");
		book.setAuthor("Aditya Bhargava");
 		book.setPrice(25.00);
		book.setLanguage("English");
		bookMap.put(book.getId(),book);
	}
	
	@Override
	public Collection<Book> findAll() {
		return bookMap.values();
	}

	@Override
	public Book findById(Long id) {
		return bookMap.get(id);
	}

	@Override
	public Book save(Book book) {
		Long newBookId = ++BookId;
		book.setId(newBookId);
		bookMap.put(book.getId(), book);
		return bookMap.get(newBookId);
	}

	@Override
	public Book update(Book book) {
		BookId = book.getId();
		 if(bookMap.get(BookId) != null) {
			 bookMap.put(BookId, book);
			 return bookMap.get(BookId);
		 }
		return null;
	}

	@Override
	public Book deleteById(Long id) {
		if(bookMap.get(id) != null) {
			return bookMap.remove(id); 
		}
		return null;
	}

}
