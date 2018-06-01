package com.jmu.orderticket.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.jmu.orderticket.bean.Flight;
import com.jmu.orderticket.service.FlightDateService;
import com.jmu.orderticket.service.FlightService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MakeFlightAction extends ActionSupport implements ModelDriven<Flight> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FlightService flightService;
	private FlightDateService flightDateService;

	public FlightDateService getFlightDateService() {
		return flightDateService;
	}

	public void setFlightDateService(FlightDateService flightDateService) {
		this.flightDateService = flightDateService;
	}

	public FlightService getFlightService() {
		return flightService;
	}

	public void setFlightService(FlightService flightService) {
		this.flightService = flightService;
	}

	//制定航班
	public String makefligt() {
		ServletActionContext.getRequest().getSession().setAttribute("flight", flight);
		flightService.increase(flight);
		return "makefligt";
	}

	//获取管理员
	public void getadmin() {
		String adminname = (String) ServletActionContext.getRequest().getSession().getAttribute("adminname");
		String jsonStr = new Gson().toJson(adminname);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/text");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//显示刚制定的航班
	public void listflight() {
		String jsonStr = new Gson().toJson(ServletActionContext.getRequest().getSession().getAttribute("flight"));
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/text");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//显示所有制定的航班
	public void listallflight(){
		List<Flight> list=flightService.getallflight();
		String jsonStr = new Gson().toJson(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/text");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//取消航班
	public String removeflightdate(){
		String fno = ServletActionContext.getRequest().getParameter("fno").trim();
		flightDateService.remove(fno);
		return "removeflightdate";
	}

	//取消刚制定的航班
	public String removeflight() {
		String fno = ServletActionContext.getRequest().getParameter("fno").trim();
		flightService.remove(fno);
		flightDateService.remove(fno);
		return "removeflight";
	}

	//注销
	public void adminlogout() {
		ServletActionContext.getRequest().getSession().invalidate();
	}

	private Flight flight = new Flight();

	@Override
	public Flight getModel() {
		return flight;
	}

}
