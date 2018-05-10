package com.jmu.orderticket.serviceImpl;

import com.jmu.orderticket.dao.AdminDao;
import com.jmu.orderticket.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao admindao;

	public AdminDao getAdmindao() {
		return admindao;
	}

	public void setAdmindao(AdminDao admindao) {
		this.admindao = admindao;
	}

	@Override
	public boolean adminLogin(String adminname, String password) {
		if (admindao.getAdmin(adminname, password) != null) {
			return true;
		}
		return false;
	}

}
