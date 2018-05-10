package com.jmu.orderticket.service;

import java.util.List;

import com.jmu.orderticket.bean.Orders;
import com.jmu.orderticket.eneities.FlightMessage;
import com.jmu.orderticket.eneities.OrderMessage;

public interface OrdersService {
	boolean placeorders(Orders orders);

	List<OrderMessage> showorders(String username);

	boolean buyticket(String fno,String date);
	
	List<FlightMessage> changeorder(String startplace,String endplace);
	
	boolean returnticket(String startplace,String endplace,String date);
	
	boolean beforeplaceorder(String name,String fno,String date);
	
	boolean placeneworder(String startplace,String endplace,String name,String date,String newdate);
	
	boolean deleteorder(String startplace, String endplace, String name, String date);
}
