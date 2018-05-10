package com.jmu.orderticket.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.jmu.orderticket.dao.TicketsDao;
import com.jmu.orderticket.eneities.FlightMessage;
import com.jmu.orderticket.service.TicketsService;

public class TicketsServiceImpl implements TicketsService {
	private TicketsDao ticketsDao;

	public TicketsDao getTicketsDao() {
		return ticketsDao;
	}

	public void setTicketsDao(TicketsDao ticketsDao) {
		this.ticketsDao = ticketsDao;
	}

	@Override
	public List<FlightMessage> orderTicketsByDate(String date, String startplace, String endplace) {
		List<Object[]> lists = ticketsDao.getFlightDateByDate(date, startplace, endplace);
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
	public List<FlightMessage> showFreeFlight() {
		List<Object[]> lists = ticketsDao.getFreeFlightDate();
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

}
