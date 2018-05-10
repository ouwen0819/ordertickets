package com.jmu.orderticket.dao;

import java.util.List;

import com.jmu.orderticket.bean.UserMessage;

public interface UserMessageDao {
	void add(UserMessage userMessage);

	List<Object[]> getusermessgebyusername(String username);

	boolean update(UserMessage userMessage);
}
