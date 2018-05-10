package com.jmu.orderticket.dao;

import com.jmu.orderticket.bean.User;

public interface UserDao {
	void add(User user);

	User getUserByName(String username);
	
	User getUser(String username,String password);
	
}
