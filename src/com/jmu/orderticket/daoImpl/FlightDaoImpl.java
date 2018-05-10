package com.jmu.orderticket.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jmu.orderticket.bean.Flight;
import com.jmu.orderticket.dao.FlightDao;

public class FlightDaoImpl implements FlightDao{

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
	public void add(Flight flight) {
		getSession().save(flight);
	}

	@Override
	public Flight getflightbyplace(String startplace, String endplace) {
		String sql="SELECT * FROM flight WHERE STARTPLACE=? and ENDPLACE=?";
		Flight flight=(Flight) getSession().createSQLQuery(sql).setString(0, startplace).setString(1, endplace).uniqueResult();
		return flight;
	}

	@Override
	public void delete(String fno) {
		String sql="delete from flight where fno=?";
		getSession().createSQLQuery(sql).setString(0, fno).executeUpdate();
	}

	@Override
	public int getfid(String startplace, String endplace) {
		String sql="select fid from flight where startplace=? and endplace=?";
		int fid=(int) getSession().createSQLQuery(sql).setString(0, startplace).setString(1, endplace).uniqueResult();
		return fid;
	}

	@Override
	public List<Object[]> getflight() {
		String sql="select * from flight";
		List<Object[]> lists=getSession().createSQLQuery(sql).list();
		return lists;
	}

}
