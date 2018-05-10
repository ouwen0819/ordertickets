package com.jmu.orderticket.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jmu.orderticket.bean.Orders;
import com.jmu.orderticket.dao.OrdersDao;
import com.jmu.orderticket.eneities.OrderName;

public class OrdersDaoImpl implements OrdersDao {
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
	public void add(Orders orders) {
		getSession().save(orders);
	}

	@Override
	public List<Object[]> getOrders(String username) {
		String sql = "SELECT o.omid,o.ofid,f.startplace,f.endplace,f.price,f.time,o.ofdid,o.name,o.phone,o.date from flight f,orders o WHERE f.FNO=o.OFID AND o.OUID=?";
		Query query = getSession().createSQLQuery(sql).setString(0, username);
		List<Object[]> list = query.list();
		return list;
	}

	@Override
	public boolean getticket(String fno, String date) {
		String sql = "select number from flightdate d,flight f where d.FFID = f.FID and f.FNO=? and d.DATE=?";
		int number = (int) getSession().createSQLQuery(sql).setString(0, fno).setString(1, date).uniqueResult();
		if (number == 0) {
			return false;
		} else {
			String sql1 = "update flightdate d set d.number=d.number-1 where d.FFID=(select f.FID FROM flight f WHERE f.fno=?) AND d.date=?";
			getSession().createSQLQuery(sql1).setString(0, fno).setString(1, date).executeUpdate();
			return true;
		}
	}

	@Override
	public List<Object[]> getchangeorder(String startplace, String endplace) {
		String sql = "SELECT y.FNO,y.STARTPLACE,y.ENDPLACE,y.PRICE,y.TIME,t.DATE,t.NUMBER from flightdate"
				+ " t left join flight y on t.FFID = y.FID where y.startplace=? and y.endplace=?";
		List<Object[]> lists = getSession().createSQLQuery(sql).setString(0, startplace).setString(1, endplace).list();
		return lists;
	}

	@Override
	public boolean reduceticket(String startplace, String endplace, String date) {
		String sql = "select d.number from flightdate d,flight f where d.FFID=f.FID and f.STARTPLACE=? AND f.ENDPLACE=? AND d.DATE=?";
		int number = (int) getSession().createSQLQuery(sql).setString(0, startplace).setString(1, endplace)
				.setString(2, date).uniqueResult();
		if (number == 0) {
			return false;
		} else {
			String sql1 = "update flightdate d set d.number=d.number+1 where d.FFID=(select f.FID FROM flight f WHERE f.startplace=? AND f.endplace=?) AND d.date=?";
			getSession().createSQLQuery(sql1).setString(0, startplace).setString(1, endplace).setString(2, date)
					.executeUpdate();
			return true;
		}
	}

	@Override
	public List<Object[]> getorderbyname(String name, String fno, String date) {
		String sql = "select o.name,o.ofid,o.ofdid from orders o where o.name=? and o.ofid=? and o.ofdid=?";
		List<Object[]> list = getSession().createSQLQuery(sql).setString(0, name).setString(1, fno).setString(2, date)
				.list();
		return list;
	}

	@Override
	public boolean againorder(String startplace, String endplace, String name, String date, String newdate) {
		String sql = "UPDATE orders o SET o.OFDID=? where o.NAME=? AND o.OFDID=? and o.OFID=(select fno from flight where STARTPLACE=? and ENDPLACE=?)";
		getSession().createSQLQuery(sql).setString(0, newdate).setString(1, name).setString(2, date)
				.setString(3, startplace).setString(4, endplace).executeUpdate();
		return true;
	}

	@Override
	public boolean delete(String startplace, String endplace, String name, String date) {
		String sql = "DELETE FROM orders where NAME=? AND OFDID=? AND OFID=(SELECT FNO FROM flight WHERE STARTPLACE=? AND ENDPLACE=?)";
		getSession().createSQLQuery(sql).setString(0, name).setString(1, date).setString(2, startplace)
				.setString(3, endplace).executeUpdate();
		return true;
	}

}
