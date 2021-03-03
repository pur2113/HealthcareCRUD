package com.paytm.learnwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paytm.learnwebapp.dao.UserDao;
import com.paytm.learnwebapp.model.User;

@Service
public class UserService {
	public String addProfile(User user) {
		UserDao dao = new UserDao();
		int rs = dao.Insert(user);
		if (rs == 0)
			return "Error Occurred.";
		else
			return "OK. 1 row(s) inserted.";
	}

	public String editProfile(User user, int id) {
		UserDao dao = new UserDao();
		int rs = dao.Update(user, id);
		if (rs == 0)
			return "Error Occurred.";
		else if (rs == -1)
			return "Row changed = 0.";
		else
			return "OK. 1 row(s) updated.";

	}

	public List<String> fetchAll() {
		UserDao dao = new UserDao();
		List<String> result = dao.SelectAll();
		return result;
	}

	public List<String> fetchByProfile(String jobrole) {
		UserDao dao = new UserDao();
		List<String> result = dao.SelectByJob(jobrole);
		return result;
	}

	public String fetchById(int id) {
		UserDao dao = new UserDao();
		String result = dao.SelectById(id);
		return result;
	}

	public String deleteProfile(int id) {
		UserDao dao = new UserDao();
		int rs = dao.Delete(id);
		if (rs == 0)
			return "Exception in fetching data.";
		else if (rs == -1)
			return "No data found with mentioned details.";
		else
			return "OK. 1 row(s) deleted.";
	}

	public String fetchEmail(int id) {
		UserDao dao = new UserDao();
		String rs = dao.findEmail(id);
		return rs;
	}
}
