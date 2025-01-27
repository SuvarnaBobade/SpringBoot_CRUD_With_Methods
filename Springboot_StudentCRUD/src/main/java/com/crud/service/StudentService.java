package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.StudentDao;
import com.crud.entitty.StudentEntity;

@Service
public class StudentService {
	@Autowired
	StudentDao dao;

	public String insertData(StudentEntity s) {
		String msg = dao.insertData(s);
		return msg;

	}
	public String deleteRecord(int stud_id) {
		String msg = dao.deleteRecord(stud_id);
		return msg;
	}
	public String updateData( StudentEntity s,int stud_id) {
		String msg = dao.updateData( s,stud_id);
		return msg;
	}

	public StudentEntity fetchOneRec(int stud_id) {
		StudentEntity se = dao.fetchOneRec(stud_id);
		return se;
	}

	public List<StudentEntity> getAllRecord() {
		List<StudentEntity> list = dao.getAllRecord();
		return list;
	}
}
