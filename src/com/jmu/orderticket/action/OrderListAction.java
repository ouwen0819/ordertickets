package com.jmu.orderticket.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.jmu.orderticket.bean.Orders;
import com.jmu.orderticket.eneities.FlightMessage;
import com.jmu.orderticket.eneities.OrderMessage;
import com.jmu.orderticket.service.OrdersService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class OrderListAction extends ActionSupport implements ModelDriven<Orders>, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private OrdersService ordersService;

	public OrdersService getOrdersService() {
		return ordersService;
	}

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	//获取历史订单
	public void myorders() {
		List<OrderMessage> list = ordersService
				.showorders((String) ServletActionContext.getRequest().getSession().getAttribute("username"));
		String jsonStr = new Gson().toJson(list);
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

	//下单
	public String orderlist() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String placedate = simpleDateFormat.format(new Date());
		orders.setOmid(String.valueOf(new Date().getTime()));
		orders.setDate(placedate);
		orders.setOuid((String) ServletActionContext.getRequest().getSession().getAttribute("username"));
		orders.setOfid(ServletActionContext.getRequest().getParameter("fno").trim());
		orders.setOfdid(ServletActionContext.getRequest().getParameter("datetime").trim());

		if (ordersService.beforeplaceorder(ServletActionContext.getRequest().getParameter("name").trim(),
				ServletActionContext.getRequest().getParameter("fno").trim(),
				ServletActionContext.getRequest().getParameter("datetime").trim())) {
			boolean flag = ordersService.placeorders(orders);
			if (flag) {
				boolean flag1 = ordersService.buyticket(orders.getOfid(), orders.getOfdid());
				if (flag1) {
					return "orderlist";
				} else {
					return "fail";
				}
			} else {
				return "fail";
			}
		} else {
			return "fail";
		}
	}

	//改签
	public String getchange() {
		ServletActionContext.getRequest().getSession().setAttribute("startplace",
				ServletActionContext.getRequest().getParameter("startplace").trim());
		ServletActionContext.getRequest().getSession().setAttribute("endplace",
				ServletActionContext.getRequest().getParameter("endplace").trim());
		ServletActionContext.getRequest().getSession().setAttribute("name",
				ServletActionContext.getRequest().getParameter("name").trim());
		ServletActionContext.getRequest().getSession().setAttribute("date",
				ServletActionContext.getRequest().getParameter("date").trim());

		ordersService.returnticket(ServletActionContext.getRequest().getParameter("startplace").trim(),
				ServletActionContext.getRequest().getParameter("endplace").trim(),
				ServletActionContext.getRequest().getParameter("date").trim());
		return "change";
	}

	//获取符合改签要求的航班
	public void changeorder() {
		String startplace = (String) ServletActionContext.getRequest().getSession().getAttribute("startplace");
		String endplace = (String) ServletActionContext.getRequest().getSession().getAttribute("endplace");
		List<FlightMessage> list = ordersService.changeorder(startplace, endplace);
		String jsonStr = new Gson().toJson(list);
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

	//重新下单
	public String againorder() {
		String startplace = (String) ServletActionContext.getRequest().getSession().getAttribute("startplace");
		String endplace = (String) ServletActionContext.getRequest().getSession().getAttribute("endplace");
		String name = (String) ServletActionContext.getRequest().getSession().getAttribute("name");
		String date = (String) ServletActionContext.getRequest().getSession().getAttribute("date");
		String newdate = ServletActionContext.getRequest().getParameter("newdate").trim();
		String fno = ServletActionContext.getRequest().getParameter("fno").trim();

		boolean flag = ordersService.placeneworder(startplace, endplace, name, date, newdate);
		if (flag) {
			boolean flag1 = ordersService.buyticket(fno, newdate);
			if (flag1) {
				return "againorder";
			} else {
				return "neworderfail";
			}
		}
		return "neworderfail";
	}

	//退票
	public String deleteorder() {
		String startplace = ServletActionContext.getRequest().getParameter("startplace").trim();
		String endplace = ServletActionContext.getRequest().getParameter("endplace").trim();
		String date = ServletActionContext.getRequest().getParameter("date").trim();
		String name = ServletActionContext.getRequest().getParameter("name").trim();
		boolean flag = ordersService.deleteorder(startplace, endplace, name, date);
		if (flag) {
			boolean flag1 = ordersService.returnticket(startplace, endplace, date);
			if (flag1) {
				return "deleteorder";
			} else {
				return "deletefail";
			}
		}
		return "deletefail";
	}

	private Orders orders;

	public void prepareOrderlist() {
		orders = new Orders();
	}

	@Override
	public void prepare() throws Exception {
	}

	@Override
	public Orders getModel() {
		return orders;
	}

}
