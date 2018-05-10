package com.jmu.orderticket.dao;

import java.util.List;

import com.jmu.orderticket.bean.Orders;

public interface OrdersDao {
	void add(Orders orders);

	List<Object[]> getOrders(String username);

	boolean getticket(String fno,String date);

	List<Object[]> getchangeorder(String startplace, String endplace);
	
	boolean reduceticket(String startplace,String endplace,String date);
	
	List<Object[]> getorderbyname(String name,String fno,String date);
	
	boolean againorder(String startplace,String endplace,String name,String date,String newdate);
	
	boolean delete(String startplace,String endplace,String name,String date);
	
}
