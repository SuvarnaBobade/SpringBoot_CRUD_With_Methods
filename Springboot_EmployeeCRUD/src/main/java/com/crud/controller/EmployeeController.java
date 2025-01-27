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
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Employee;
import com.crud.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@PostMapping("/insert")
	public String insertData(@RequestBody Employee e) {
		String msg = service.insertData(e);
		return msg;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteData(@PathVariable int id) {
		String msg = service.deleteData(id);
		return msg;
	}

	@PutMapping("/update/{id}")
	public String updateData(@RequestBody Employee e, @PathVariable int id) {
		String msg = service.updateData(e, id);
		return msg;
	}

	@GetMapping("/fetchone/{id}")
	public Employee fetchPerticular(@PathVariable int id) {
		Employee msg = service.fetchPerticular(id);
		return msg;
	}

	@GetMapping("/getallrecord")
	public List<Employee> getAllRecord() {
		List<Employee> list = service.getAllRecord();
		return list;
	}
}