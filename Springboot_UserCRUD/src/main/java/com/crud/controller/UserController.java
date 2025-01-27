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

import com.crud.entity.User;
import com.crud.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService service;

	@PostMapping("/saveData")
	public String insertData(@RequestBody User u) {
		String msg = service.insertdata(u);
		return msg;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteData(@PathVariable int id) {
		String msg = service.deleteData(id);
		return msg;

	}

	@GetMapping("/fetchone/{id}")
	public User fetchperticular(@PathVariable int id) {
		User u = service.fetchperticular(id);
		return u;

	}

	@PutMapping("/update")
	public String updatedata(@RequestParam int id, @RequestBody User u) {
		String msg = service.updatedata(id, u);
		return msg;
	}

	@GetMapping("/fetchallrecord")
	public List<User> FetchAllRecords() {
		List<User> list = service.FetchAllRecords();
		return list;
	}
}
