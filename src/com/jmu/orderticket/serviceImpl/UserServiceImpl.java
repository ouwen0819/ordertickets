package com.jmu.orderticket.serviceImpl;

import com.jmu.orderticket.bean.User;
import com.jmu.orderticket.dao.UserDao;
import com.jmu.orderticket.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean register(User user) {
		if (userDao.getUserByName(user.getUsername()) == null) {
			userDao.add(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean login(String username, String password) {
		if (userDao.getUser(username, password) != null) {
			return true;
		}
		return false;
	}


	@Override
	public boolean getAjax(User user) {
		if (userDao.getUserByName(user.getUsername()) == null) {
			return true;
		}
		return false;
	}

}
