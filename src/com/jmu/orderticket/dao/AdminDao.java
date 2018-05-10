package com.jmu.orderticket.dao;

import com.jmu.orderticket.bean.Admin;

public interface AdminDao {
	Admin getAdmin(String adminname,String password);
}
