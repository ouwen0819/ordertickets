package com.jmu.orderticket.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jmu.orderticket.dao.TicketsDao;
import com.jmu.orderticket.eneities.FlightMessage;

public class TicketsDaoImpl implements TicketsDao {
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
	public List<Object[]> getFlightDateByDate(String date, String startplace, String endplace) {
		String sql = "SELECT y.FNO,y.STARTPLACE,y.ENDPLACE,y.PRICE,y.TIME,t.DATE,t.NUMBER from flightdate t left join flight y on t.FFID = y.FID where DATE_FORMAT(t.DATE, '%Y-%m-%d') =? and y.startplace=? and y.endplace=?";
		List<Object[]> lists = getSession().createSQLQuery(sql).setString(0, date).setString(1, startplace)
				.setString(2, endplace).list();
		return lists;
	}

	@Override
	public List<Object[]> getFreeFlightDate() {
		String sql = "SELECT y.FNO,y.STARTPLACE,y.ENDPLACE,y.PRICE,y.TIME,t.DATE,t.NUMBER from flightdate t,flight y where t.FFID = y.FID";
		Query query = getSession().createSQLQuery(sql);
		List<Object[]> freeflight = query.setFirstResult((int) (Math.random() * 10)).setMaxResults(10).list();
		return freeflight;
	}

}
