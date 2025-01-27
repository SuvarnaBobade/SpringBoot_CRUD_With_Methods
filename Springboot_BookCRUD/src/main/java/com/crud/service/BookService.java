package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.BookDao;
import com.crud.entity.Book;

@Service
public class BookService {
	@Autowired
	BookDao dao;

	public String insertData(Book b) {
		String msg = dao.insertdata(b);
		return msg;
	}

	public String deleteData(int id) {
		String msg = dao.deleteData(id);
		return msg;
	}

	public String updateData(int id, Book b) {
		String msg = dao.updateData(id, b);
		return msg;
	}

	public String FetchOne(int id) {
		String msg = dao.FetchOne(id);
		return msg;
	}

	public List<Book> getAllRecord() {
		List<Book> list = dao.getAllRecord();
		return list;
	}
}
