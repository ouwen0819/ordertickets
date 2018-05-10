package com.jmu.orderticket.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.jmu.orderticket.bean.FlightDate;
import com.jmu.orderticket.dao.FlightDateDao;
import com.jmu.orderticket.eneities.FlightDateMessage;
import com.jmu.orderticket.service.FlightDateService;

public class FlightDateServiceImpl implements FlightDateService {
	private FlightDateDao flightDateDao;

	public FlightDateDao getFlightDateDao() {
		return flightDateDao;
	}

	public void setFlightDateDao(FlightDateDao flightDateDao) {
		this.flightDateDao = flightDateDao;
	}

	@Override
	public void arrange(FlightDate flightDate) {
		flightDateDao.add(flightDate);
	}

	@Override
	public void remove(String fno) {
		flightDateDao.delete(fno);
	}

	@Override
	public List<FlightDateMessage> getflightdate() {
		List<Object[]> list = flightDateDao.getall();
		List<FlightDateMessage> lists = new ArrayList<>();

		for (int i = 0; i < list.size() && lists != null; i++) {
			Object[] objects = list.get(i);
			if (objects.length > 0) {
				FlightDateMessage flightDateMessage = new FlightDateMessage((String) objects[0], (String) objects[1],
						(String) objects[2], (double) objects[3], (String) objects[4], (int) objects[5],
						(String) objects[6]);
				lists.add(flightDateMessage);
			}
		}
		return lists;
	}

}
