package com.jmu.orderticket.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.jmu.orderticket.bean.User;
import com.jmu.orderticket.service.AdminService;
import com.jmu.orderticket.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class UserAction extends ActionSupport implements ModelDriven<User>, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService userService;
	private AdminService adminService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public String ajaxregister() throws UnsupportedEncodingException {
		boolean flag = userService.getAjax(user);
		if (flag) {
			inputStream = new ByteArrayInputStream("true".getBytes("UTF-8"));
		} else {
			inputStream = new ByteArrayInputStream("false".getBytes("UTF-8"));
		}
		return "ajax-success";
	}

	public void prepareAjaxregister() {
		user = new User();
	}

	public String register() {
		if (user.getUsername()!= null && user.getPassword() != null && user.getPhone()!= null
				&& user.getEmail() != null) {
			boolean flag = userService.register(user);
			System.out.println("用户是否注册成功:" + flag);
			if (flag) {
				ServletActionContext.getRequest().getSession().setAttribute("username", user.getUsername());
				return "register";
			} else {
				return "fail";
			}
		} else {
			return "fail";
		}
	}

	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private String checkcode;

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public String login() {
		// 判断验证码程序
		// 从Session中获得验证码的随机值
		String checkcode1 = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if (!checkcode.equalsIgnoreCase(checkcode1)) {
			return "fail";
		}
		if (role.equals("1")) {
			boolean flag = userService.login(user.getUsername(), user.getPassword());
			if (flag) {
				ServletActionContext.getRequest().getSession().setAttribute("username", user.getUsername());
				return "login";
			} else {
				return "fail";
			}
		} else {
			boolean flag1 = adminService.adminLogin(user.getUsername(), user.getPassword());
			if (flag1) {
				ServletActionContext.getRequest().getSession().setAttribute("adminname", user.getUsername());
				return "adminlogin";
			} else {
				return "fail";
			}
		}
	}

	public void getuser() {
		String username = (String) ServletActionContext.getRequest().getSession().getAttribute("username");
		String jsonStr = new Gson().toJson(username);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/text");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logout() {
		ServletActionContext.getRequest().getSession().invalidate();
	}

	public void prepareLogin() {
		user = new User();
	}

	public void prepareRegister() {
		user = new User();
	}

	@Override
	public void prepare() throws Exception {
	}

	private User user;

	@Override
	public User getModel() {
		return user;
	}

}
