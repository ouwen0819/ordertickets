package com.jmu.orderticket.service;

import java.util.List;

import com.jmu.orderticket.eneities.FlightMessage;

public interface TicketsService {
	List<FlightMessage> orderTicketsByDate(String date,String startplace,String endplace);
	List<FlightMessage> showFreeFlight();
}
