package com.jmu.orderticket.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jmu.orderticket.bean.User;
import com.jmu.orderticket.dao.UserDao;

public class UserDaoImpl implements UserDao {
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
	public void add(User user) {
		getSession().save(user);
	}

	@Override
	public User getUserByName(String username) {
		String hql = "from User where username=?";
		Query query = getSession().createQuery(hql).setString(0, username);
		return (User) query.uniqueResult();
	}
	
	@Override
	public User getUser(String username, String password) {
		String hql = "from User where username=? and password=?";
		Query query=getSession().createQuery(hql).setString(0, username).setString(1, password);
		return (User) query.uniqueResult();
	}

}
