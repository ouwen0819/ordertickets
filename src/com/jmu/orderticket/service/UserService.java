package com.jmu.orderticket.service;

import com.jmu.orderticket.bean.User;

public interface UserService {

	boolean register(User user);

	boolean login(String username, String password);

	boolean getAjax(User user);
}
