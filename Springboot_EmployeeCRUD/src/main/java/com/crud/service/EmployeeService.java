package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.EmployeeDao;
import com.crud.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empdao;

	public String insertData(Employee e) {
		String msg = empdao.insertData(e);
		return msg;
	}

	public String deleteData(int id) {
		String msg = empdao.deleteData(id);
		return msg;
	}

	public String updateData(Employee e, int id) {
		String msg = empdao.updateData(e, id);
		return msg;
	}

	public Employee fetchPerticular(int id) {
		Employee msg = empdao.fetchPerticular(id);
		return msg;
	}

	public List<Employee> getAllRecord() {
		List<Employee> list=empdao.getAllRecord();
		return list;
		
	}
}
