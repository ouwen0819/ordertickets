package com.jmu.orderticket.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.jmu.orderticket.bean.FlightDate;
import com.jmu.orderticket.eneities.FlightDateMessage;
import com.jmu.orderticket.service.FlightDateService;
import com.jmu.orderticket.service.FlightService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FlightDateAction extends ActionSupport implements ModelDriven<FlightDate> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FlightDateService flightDateService;

	private FlightService flightService;

	public FlightService getFlightService() {
		return flightService;
	}

	public void setFlightService(FlightService flightService) {
		this.flightService = flightService;
	}

	public FlightDateService getFlightDateService() {
		return flightDateService;
	}

	public void setFlightDateService(FlightDateService flightDateService) {
		this.flightDateService = flightDateService;
	}

	private FlightDate flightDate = new FlightDate();

	//安排航班
	public String arrangeflight() {
		String startplace=ServletActionContext.getRequest().getParameter("splace");
		String endplace=ServletActionContext.getRequest().getParameter("eplace");	
		String ffid=flightService.beforearrange(startplace, endplace);
		flightDate.setFfid(ffid);
		flightDateService.arrange(flightDate);
		return "arrangeflight";
	}
	
	//显示所有航班信息
	public void listflightdate(){
		List<FlightDateMessage> list=flightDateService.getflightdate();
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

	@Override
	public FlightDate getModel() {
		return flightDate;
	}

}
