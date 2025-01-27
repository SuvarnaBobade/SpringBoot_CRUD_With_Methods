package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Book;
import com.crud.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookService service;

	@PostMapping("/save")
	public String insertData(@RequestBody Book b) {
		String msg = service.insertData(b);
		return msg;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteData(@PathVariable int id) {
		String msg = service.deleteData(id);
		return msg;
	}

	@PutMapping("/update/{id}")
	public String updateData(@PathVariable int id, @RequestBody Book b) {
		String msg = service.updateData(id, b);
		return msg;
	}

	@GetMapping("/fetch/{id}")
	public String FetchOne(@PathVariable int id) {
		String msg = service.FetchOne(id);
		return msg;

	}

	@GetMapping("/getallRecord")
	public List<Book> getAllRecord() {
		List<Book> list = service.getAllRecord();
		return list;
	}

}
