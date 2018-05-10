package com.jmu.orderticket.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.jmu.orderticket.eneities.FlightMessage;
import com.jmu.orderticket.service.TicketsService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class OrderTicketsAction extends ActionSupport implements ModelDriven<FlightMessage>, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TicketsService ticketsService;

	public TicketsService getTicketsService() {
		return ticketsService;
	}

	public void setTicketsService(TicketsService ticketsService) {
		this.ticketsService = ticketsService;
	}

	private static List<FlightMessage> list = null;

	public String ordertickets() {
		list = ticketsService.orderTicketsByDate(flightMessage.getTime(), flightMessage.getStartplace(),
				flightMessage.getEndplace());
		return "ordertickets";
	}

	public void ajax() throws IOException {
		String jsonStr = new Gson().toJson(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonStr);
	}

	private List<FlightMessage> mainlist = null;

	public void mainorder() {
		mainlist = ticketsService.showFreeFlight();
		String jsonStr = new Gson().toJson(mainlist);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/text");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(jsonStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void prepareOrdertickets() {
		flightMessage = new FlightMessage();
	}

	@Override
	public void prepare() throws Exception {
	}

	private FlightMessage flightMessage;

	@Override
	public FlightMessage getModel() {
		return flightMessage;
	}

}
