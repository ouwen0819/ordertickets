package com.jmu.orderticket.dao;

import java.util.List;

import com.jmu.orderticket.bean.Flight;

public interface FlightDao {
	void add(Flight flight);

	Flight getflightbyplace(String startplace, String endplace);
	
	void delete(String fno);
	
	int getfid(String startplace,String endplace);
	
	List<Object[]> getflight();
}
