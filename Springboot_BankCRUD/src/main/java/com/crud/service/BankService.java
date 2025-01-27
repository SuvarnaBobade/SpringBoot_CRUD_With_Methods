package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.BankDao;
import com.crud.entity.Bank;

@Service
public class BankService {
	@Autowired
	BankDao dao;

	public String insertdate(Bank b) {
		String msg = dao.insertData(b);
		return msg;
	}

	public String deleteData(int id) {
		String msg = dao.deleteData(id);
		return msg;
	}

	public String updateData(int id, Bank b) {
		String msg = dao.updateData(id, b);
		return msg;
	}

	public String fetchOne(int id) {
		String msg = dao.fetchOne(id);
		return msg;
	}

	public List<Bank> getAllRecord() {
		List<Bank> list = dao.getAllRecord();
		return list;
	}

}
