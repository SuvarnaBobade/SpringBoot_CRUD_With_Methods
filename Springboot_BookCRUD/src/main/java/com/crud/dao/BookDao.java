package com.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.entity.Book;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class BookDao {
	@Autowired
	SessionFactory sf;

	public String insertdata(Book b) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		ss.persist(b);
		tr.commit();
		ss.close();
		return "Data inserted sucessfully.......!";
	}

	public String deleteData(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Book b = ss.get(Book.class, id);
		ss.remove(b);
		tr.commit();
		ss.close();
		return "Data deelted sucessfully........!";
	}

	public String updateData(int id, Book b) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Book b1 = ss.get(Book.class, id);
		b1.setAuthor(b.getAuthor());
		b1.setTitle(b.getTitle());
		ss.merge(b1);
		tr.commit();
		ss.close();
		return "Data updated sucessfully......!";
	}

	public String FetchOne(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Book b = ss.get(Book.class, id);
		tr.commit();
		ss.close();
		return "perticular record is" + b.toString();
	}

	public List<Book> getAllRecord() {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		HibernateCriteriaBuilder hcb = ss.getCriteriaBuilder();
		CriteriaQuery<Object> cq = hcb.createQuery();
		Root<Book> root = cq.from(Book.class);
		Query query = ss.createQuery(cq);
		List<Book> list = query.getResultList();
		tr.commit();
		ss.close();
		return list;

	}
}
