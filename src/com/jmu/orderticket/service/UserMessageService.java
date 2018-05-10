package com.jmu.orderticket.service;

import com.jmu.orderticket.bean.UserMessage;

public interface UserMessageService {
	boolean inputmessage(UserMessage userMessage);

	UserMessage getusermessage(String username);

	boolean edit(UserMessage userMessage);
}
