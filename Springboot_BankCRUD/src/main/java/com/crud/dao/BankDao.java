package com.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.entity.Bank;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class BankDao {
	@Autowired
	SessionFactory sf;

	public String insertData(Bank b) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		ss.persist(b);
		tr.commit();
		ss.close();
		return "data inserted sucessfully......!";

	}

	public String deleteData(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Bank b = ss.get(Bank.class, id);
		ss.remove(b);
		tr.commit();
		ss.close();
		return "Data deleted Sucessfully........!";
	}

	public String updateData(int id, Bank b) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Bank b1 = ss.get(Bank.class, id);
		b1.setAddress(b.getAddress());
		b1.setBranchCode(b.getBranchCode());
		b1.setName(b.getName());
		b1.setPhoneNumber(b.getPhoneNumber());
		ss.merge(b1);
		tr.commit();
		ss.close();
		return "data updated sucessfully..!";
	}

	public String fetchOne(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Bank b = ss.get(Bank.class, id);
		return "perticular record :" + b.toString();
	}

	public List<Bank> getAllRecord() {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		HibernateCriteriaBuilder hcb = ss.getCriteriaBuilder();
		CriteriaQuery<Object> cq = hcb.createQuery();
		Root<Bank> root = cq.from(Bank.class);
		Query query = ss.createQuery(cq);
		List<Bank> list = query.getResultList();
		return list;

	}

}
