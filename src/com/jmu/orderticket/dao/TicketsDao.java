package com.jmu.orderticket.dao;

import java.util.List;

public interface TicketsDao {
	List<Object[]> getFlightDateByDate(String date, String startplace, String endplace);

	List<Object[]> getFreeFlightDate();
}
