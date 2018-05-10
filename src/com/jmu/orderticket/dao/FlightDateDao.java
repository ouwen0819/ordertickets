package com.jmu.orderticket.dao;

import java.util.List;

import com.jmu.orderticket.bean.FlightDate;

public interface FlightDateDao {
	void add(FlightDate flightDate);

	void delete(String fno);
	
	List<Object[]> getall();
}
