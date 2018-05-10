package com.jmu.orderticket.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.jmu.orderticket.bean.Flight;
import com.jmu.orderticket.dao.FlightDao;
import com.jmu.orderticket.service.FlightService;

public class FlightServiceImpl implements FlightService {
	private FlightDao flightdao;

	public FlightDao getFlightdao() {
		return flightdao;
	}

	public void setFlightdao(FlightDao flightdao) {
		this.flightdao = flightdao;
	}

	@Override
	public void increase(Flight flight) {
		if (flightdao.getflightbyplace(flight.getStartplace(), flight.getEndplace()) == null) {
			flightdao.add(flight);
		}
	}

	@Override
	public void remove(String fno) {
		flightdao.delete(fno);
	}

	@Override
	public String beforearrange(String startplace, String endplace) {
		String fid = String.valueOf(flightdao.getfid(startplace, endplace));
		return fid;
	}

	@Override
	public List<Flight> getallflight() {
		List<Object[]> list = flightdao.getflight();
		List<Flight> lists = new ArrayList<>();

		for (int i = 0; i < list.size() && lists != null; i++) {
			Object[] objects = list.get(i);
			if (objects.length > 0) {
				Flight flight = new Flight((int) objects[0], (String) objects[1], (String) objects[2],
						(String) objects[3], (String) objects[4], (double) objects[5]);
				lists.add(flight);
			}
		}

		return lists;
	}

}
