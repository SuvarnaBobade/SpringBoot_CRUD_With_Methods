package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.UserDao;
import com.crud.entity.User;

@Service
public class UserService {
	@Autowired
	UserDao dao;

	public String insertdata(User u) {
		String msg = dao.insertData(u);
		return msg;
	}

	public String deleteData(int id) {
		String msg = dao.deleteData(id);
		return msg;
	}

	public User fetchperticular(int id) {
		User u = dao.fetchperticular(id);
		return u;
	}

	public String updatedata(int id, User u) {
		String msg = dao.updatedata(id, u);
		return msg;
	}

	public List<User> FetchAllRecords() {
		List<User> list = dao.FetchAllRecords();
		return list;

	}
}
