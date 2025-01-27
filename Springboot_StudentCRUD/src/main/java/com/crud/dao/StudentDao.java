package com.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.entitty.StudentEntity;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class StudentDao {
	@Autowired
	SessionFactory sf;

	public String insertData(StudentEntity s) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		ss.persist(s);
		tr.commit();
		ss.close();

		return "Data Inserted Successfully......!";

	}

	public String deleteRecord(int stud_id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		StudentEntity se = ss.get(StudentEntity.class, stud_id);
		ss.remove(se);
		tr.commit();
		ss.close();

		return "delete record sucessfully.......!";

	}

	public String updateData(StudentEntity s, int stud_id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		StudentEntity se = ss.get(StudentEntity.class, stud_id);
		se.setCity(s.getCity());
		se.setMobile_no(s.getMobile_no());
		se.setStud_name(s.getStud_name());
		ss.merge(se);
		tr.commit();
		ss.close();

		return "data updated ....";
	}

	public StudentEntity fetchOneRec(int stud_id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		StudentEntity se = ss.get(StudentEntity.class, stud_id);
		tr.commit();
		ss.close();
		return se;

	}

	public List<StudentEntity> getAllRecord() {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		HibernateCriteriaBuilder hcb = ss.getCriteriaBuilder();
		CriteriaQuery<Object> cq = hcb.createQuery();
		Root<StudentEntity> root = cq.from(StudentEntity.class);
		Query query = ss.createQuery(cq);
		List<StudentEntity> list = query.getResultList();
		return list;

	}

}
