package com.jmu.orderticket.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jmu.orderticket.bean.FlightDate;
import com.jmu.orderticket.dao.FlightDateDao;

public class FlightDateDaoImpl implements FlightDateDao{

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
	public void add(FlightDate flightDate) {
		getSession().save(flightDate);
	}

	@Override
	public void delete(String fno) {
		String sql="delete from flightdate where ffid=(select fid from flight where fno=?)";
		getSession().createSQLQuery(sql).setString(0, fno).executeUpdate();
	}

	@Override
	public List<Object[]> getall() {
		String sql="select f.fno,f.startplace,f.endplace,f.price,f.time,d.number,d.date from flightdate d,flight f where d.ffid=f.fid";
		List<Object[]> list=getSession().createSQLQuery(sql).list();
		return list;
	}

}
