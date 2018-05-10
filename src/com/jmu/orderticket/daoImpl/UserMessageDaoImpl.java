package com.jmu.orderticket.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jmu.orderticket.bean.UserMessage;
import com.jmu.orderticket.dao.UserMessageDao;

public class UserMessageDaoImpl implements UserMessageDao {
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
	public void add(UserMessage userMessage) {
		getSession().save(userMessage);
	}

	@Override
	public List<Object[]> getusermessgebyusername(String username) {
		String sql = "select * from usermessage where uuid=?";
		List<Object[]> list = getSession().createSQLQuery(sql).setString(0, username).list();
		return list;
	}

	@Override
	public boolean update(UserMessage userMessage) {
		String sql = "UPDATE usermessage SET NAME=?,AGE=?,SEX=?,IDCARD=?,BIRTHDATE=? WHERE UUID=?";
		getSession().createSQLQuery(sql).setString(0, userMessage.getName()).setInteger(1, userMessage.getAge())
				.setString(2, userMessage.getSex()).setString(3, userMessage.getIdcard())
				.setString(4, userMessage.getBirthdate()).setString(5, userMessage.getUuid()).executeUpdate();
		return true;
	}

}
