package com.jmu.orderticket.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.jmu.orderticket.bean.UserMessage;
import com.jmu.orderticket.service.UserMessageService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class UserMessageAction extends ActionSupport implements ModelDriven<UserMessage>, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserMessageService userMessageService;

	public UserMessageService getUserMessageService() {
		return userMessageService;
	}

	public void setUserMessageService(UserMessageService userMessageService) {
		this.userMessageService = userMessageService;
	}

	//录入个人信息
	public String usermessage() {
		String username = (String) ServletActionContext.getRequest().getSession().getAttribute("username");
		userMessage.setUuid(username);
		if (userMessageService.inputmessage(userMessage)) {
			return SUCCESS;
		} else {
			return "fail";
		}
	}

	//获取用户基本信息
	public void getmessage() {
		UserMessage userMessage1 = userMessageService
				.getusermessage((String) ServletActionContext.getRequest().getSession().getAttribute("username"));
		String jsonStr = new Gson().toJson(userMessage1);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/text");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(jsonStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//获取用户信息
	public String editmessage() {
		UserMessage userMessage = userMessageService
				.getusermessage(ServletActionContext.getRequest().getParameter("username"));
		ServletActionContext.getRequest().getSession().setAttribute("usermessage", userMessage);
		return "editmessage";
	}

	//ajax显示用户信息
	public void getusermessage() {
		UserMessage userMessage = (UserMessage) ServletActionContext.getRequest().getSession()
				.getAttribute("usermessage");
		String jsonStr = new Gson().toJson(userMessage);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/text");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(jsonStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//修改用户信息
	public String editusermessage() {
		String uuid = (String) ServletActionContext.getRequest().getSession().getAttribute("username");
		String name = ServletActionContext.getRequest().getParameter("name").trim();
		String age = ServletActionContext.getRequest().getParameter("age").trim();
		String sex = ServletActionContext.getRequest().getParameter("sex").trim();
		String idcard = ServletActionContext.getRequest().getParameter("idcard").trim();
		String birthdate = ServletActionContext.getRequest().getParameter("birthdate").trim();
		
		UserMessage userMessage1 = new UserMessage(null, name, Integer.valueOf(age), sex, idcard, birthdate, uuid);
		if (userMessageService.edit(userMessage1)) {
			return "editusermessage";
		}
		return "fail";
	}

	private UserMessage userMessage;

	public void prepareUsermessage() {
		userMessage = new UserMessage();
	}

	@Override
	public void prepare() throws Exception {
	}

	@Override
	public UserMessage getModel() {
		return userMessage;
	}

}
