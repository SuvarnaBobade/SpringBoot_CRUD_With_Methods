package com.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.entity.User;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class UserDao {
	@Autowired
	SessionFactory sf;

	public String insertData(User u) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		ss.persist(u);
		tr.commit();
		ss.close();
		return "Data inserted Sucessfully............!";
	}

	public String deleteData(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		User us = ss.get(User.class, id);
		ss.remove(us);
		tr.commit();
		ss.close();
		return "Data is Deleted sucessfully.............!";
	}

	public User fetchperticular(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		User u = ss.get(User.class, id);
		tr.commit();
		ss.close();
		return u;

	}

	public String updatedata(int id, User u) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		User u1 = ss.get(User.class, id);
		u1.setEmail(u.getEmail());
		u1.setPassword(u.getPassword());
		u1.setUsername(u.getUsername());
		ss.merge(u1);
		tr.commit();
		ss.close();
		return "Record updated sucessfully..........!";
	}

	public List<User> FetchAllRecords() {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		HibernateCriteriaBuilder hcb = ss.getCriteriaBuilder();
		CriteriaQuery<Object> cq = hcb.createQuery();
		Root<User> root = cq.from(User.class);
		Query query = ss.createQuery(cq);
		List<User> list = query.getResultList();
		return list;

	}

}
