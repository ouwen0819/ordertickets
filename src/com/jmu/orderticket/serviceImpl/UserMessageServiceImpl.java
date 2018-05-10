package com.jmu.orderticket.serviceImpl;

import java.util.List;

import com.jmu.orderticket.bean.UserMessage;
import com.jmu.orderticket.dao.UserMessageDao;
import com.jmu.orderticket.service.UserMessageService;

public class UserMessageServiceImpl implements UserMessageService {
	private UserMessageDao userMessageDao;

	public UserMessageDao getUserMessageDao() {
		return userMessageDao;
	}

	public void setUserMessageDao(UserMessageDao userMessageDao) {
		this.userMessageDao = userMessageDao;
	}

	@Override
	public boolean inputmessage(UserMessage userMessage) {
		if (userMessageDao.getusermessgebyusername(userMessage.getUuid()).size() == 0) {
			userMessageDao.add(userMessage);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public UserMessage getusermessage(String username) {
		List<Object[]> list = userMessageDao.getusermessgebyusername(username);
		UserMessage userMessage = new UserMessage();
		for (int i = 0; i < list.size()&& list != null; i++) {
			Object[] objects = list.get(i);
			if (objects.length > 0) {
				userMessage = new UserMessage((int) objects[0], (String) objects[1], (int) objects[2],
						(String) objects[3], (String) objects[4], (String) objects[5], (String) objects[6]);
			}
		}
		return userMessage;
	}

	@Override
	public boolean edit(UserMessage userMessage) {
		if (userMessageDao.update(userMessage)) {
			return true;
		}
		return false;
	}
}
