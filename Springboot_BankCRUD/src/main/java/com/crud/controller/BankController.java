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

import com.crud.entity.Bank;
import com.crud.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {
	@Autowired
	BankService service;

	@PostMapping("/savedata")
	public String insertdata(@RequestBody Bank b) {
		String msg = service.insertdate(b);
		return msg;
	}

	@DeleteMapping("/deletedata/{id}")
	public String deleteData(@PathVariable int id) {
		String msg = service.deleteData(id);
		return msg;
	}

	@PutMapping("/update")
	public String updateData(@RequestParam int id, @RequestBody Bank b) {
		String msg = service.updateData(id, b);
		return msg;
	}

	@GetMapping("/fetch/{id}")
	public String fetchOne(@PathVariable int id) {
		String msg = service.fetchOne(id);
		return msg;
	}

	@GetMapping("/getallrecord")
	public List<Bank> getAllRecord() {
		List<Bank> list = service.getAllRecord();
		return list;
	}

}
