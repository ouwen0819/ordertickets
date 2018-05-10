package com.jmu.orderticket.service;

import java.util.List;

import com.jmu.orderticket.bean.Flight;

public interface FlightService {
	void increase(Flight flight);

	void remove(String fno);
	
	String beforearrange(String startplace,String endplace);
	
	List<Flight> getallflight();
}
