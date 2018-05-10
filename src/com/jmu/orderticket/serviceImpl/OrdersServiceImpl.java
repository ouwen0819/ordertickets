package com.jmu.orderticket.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.jmu.orderticket.bean.Orders;
import com.jmu.orderticket.dao.OrdersDao;
import com.jmu.orderticket.eneities.FlightMessage;
import com.jmu.orderticket.eneities.OrderMessage;
import com.jmu.orderticket.service.OrdersService;

public class OrdersServiceImpl implements OrdersService {
	private OrdersDao ordersDao;

	public OrdersDao getOrdersDao() {
		return ordersDao;
	}

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	@Override
	public boolean placeorders(Orders orders) {
		ordersDao.add(orders);
		return true;
	}

	@Override
	public List<OrderMessage> showorders(String username) {
		List<Object[]> lists = ordersDao.getOrders(username);
		List<OrderMessage> list = new ArrayList<OrderMessage>();
		for (int i = 0; i < lists.size() && lists != null; i++) {
			Object[] objects = lists.get(i);
			if (objects.length > 0) {
				OrderMessage orderMessage = new OrderMessage((String) objects[0], (String) objects[1],
						(String) objects[2], (String) objects[3], (double) objects[4], (String) objects[5],
						(String) objects[6], (String) objects[7], (String) objects[8], (String) objects[9]);
				list.add(orderMessage);
			}
		}
		return list;
	}

	@Override
	public boolean buyticket(String fno,String date) {
		boolean flag = ordersDao.getticket(fno,date);
		if (flag) {
			return true;
		}
		return false;
	}

	@Override
	public List<FlightMessage> changeorder(String startplace, String endplace) {
		List<Object[]> lists = ordersDao.getchangeorder(startplace, endplace);
		List<FlightMessage> list = new ArrayList<FlightMessage>();
		for (int i = 0; i < lists.size() && lists != null; i++) {
			Object[] objects = lists.get(i);
			if (objects.length > 0) {
				FlightMessage flightMessage = new FlightMessage((String) objects[0], (String) objects[1],
						(String) objects[2], (double) objects[3], (String) objects[4], (String) objects[5],
						(int) objects[6]);
				list.add(flightMessage);
			}
		}
		return list;
	}

	@Override
	public boolean returnticket(String startplace, String endplace, String date) {
		boolean flag=ordersDao.reduceticket(startplace, endplace, date);
		if(flag){
			return true;
		}
		return false;
	}

	@Override
	public boolean beforeplaceorder(String name, String fno, String date) {
		if(ordersDao.getorderbyname(name, fno, date).size()==0){
			return true;
		}
		return false;
	}

	@Override
	public boolean placeneworder(String startplace, String endplace, String name, String date, String newdate) {
		boolean flag=ordersDao.againorder(startplace, endplace, name, date, newdate);
		if(flag){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteorder(String startplace, String endplace, String name, String date) {
		boolean flag=ordersDao.delete(startplace, endplace, name, date);
		if(flag){
			return true;
		}
		return false;
	}

}
