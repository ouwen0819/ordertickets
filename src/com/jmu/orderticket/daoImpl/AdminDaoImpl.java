package com.jmu.orderticket.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jmu.orderticket.bean.Admin;
import com.jmu.orderticket.dao.AdminDao;

public class AdminDaoImpl implements AdminDao {
	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public Admin getAdmin(String adminname, String password) {
		String hql="from Admin where adminname=? and password=?";
		Query query=getSession().createQuery(hql).setString(0, adminname).setString(1, password);
		return (Admin) query.uniqueResult();
	}

}
