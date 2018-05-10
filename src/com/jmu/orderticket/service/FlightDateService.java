package com.jmu.orderticket.service;

import java.util.List;

import com.jmu.orderticket.bean.FlightDate;
import com.jmu.orderticket.eneities.FlightDateMessage;

public interface FlightDateService {
	void arrange(FlightDate flightDate);

	void remove(String fno);
	
	List<FlightDateMessage> getflightdate();
}
