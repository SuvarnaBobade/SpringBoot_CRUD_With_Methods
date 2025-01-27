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

import com.crud.entitty.StudentEntity;
import com.crud.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService service;

	@PostMapping("/insertdata")
	public String insertData(@RequestBody StudentEntity s) {
		String msg = service.insertData(s);
		return msg;

	}

	@DeleteMapping("/delete/{stud_id}")
	public String deleteData(@PathVariable int stud_id) {
		String msg = service.deleteRecord(stud_id);
		return msg;
	}

	@PutMapping("/update")
	public String updateData(@RequestBody StudentEntity s, @RequestParam int stud_id) {
		String msg = service.updateData(s, stud_id);
		return msg;
	}

	@GetMapping("/fetchone")
	public StudentEntity fetchOneRec(@RequestParam int stud_id) {
		StudentEntity se = service.fetchOneRec(stud_id);
		return se;
	}

	@GetMapping("/getAllrecord")
	public List<StudentEntity> getAllRecord() {
		List<StudentEntity> list = service.getAllRecord();
		return list;
	}

}
