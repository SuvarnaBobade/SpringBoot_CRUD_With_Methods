package com.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.entity.Employee;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class EmployeeDao {
	@Autowired
	SessionFactory sf;

	public String insertData(Employee e) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		ss.persist(e);
		tr.commit();
		ss.close();
		return "Data inserted Sucessfully........!";
	}

	public String deleteData(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Employee emp = ss.get(Employee.class, id);
		ss.remove(emp);
		tr.commit();
		ss.close();
		return "Data deleted sucessfully........";

	}

	public String updateData(Employee e, int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Employee ee = ss.get(Employee.class, id);
		ee.setDepartment(e.getDepartment());
		ee.setFirstName(e.getFirstName());
		ee.setLastName(e.getLastName());
		ee.setSalary(e.getSalary());
		ss.merge(ee);
		tr.commit();
		ss.close();

		return "data updated sucessfully.....!";
	}

	public Employee fetchPerticular(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Employee emp = ss.get(Employee.class, id);
		return emp;

	}

	public List<Employee> getAllRecord() {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		HibernateCriteriaBuilder hcb = ss.getCriteriaBuilder();
		CriteriaQuery<Object> cq = hcb.createQuery();
		Root<Employee> root = cq.from(Employee.class);
		Query query = ss.createQuery(cq);
		List<Employee> list = query.getResultList();
		return list;

	}
}
