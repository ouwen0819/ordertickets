package com.jmu.orderticket.eneities;

public class OrderMessage {
	private String omid;
	private String fno;
	private String startplace;
	private String endplace;
	private double price;
	private String time;
	private String datetime;
	private String name;
	private String phone;
	private String placetime;

	public String getOmid() {
		return omid;
	}

	public void setOmid(String omid) {
		this.omid = omid;
	}

	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	public String getStartplace() {
		return startplace;
	}

	public void setStartplace(String startplace) {
		this.startplace = startplace;
	}

	public String getEndplace() {
		return endplace;
	}

	public void setEndplace(String endplace) {
		this.endplace = endplace;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPlacetime() {
		return placetime;
	}

	public void setPlacetime(String placetime) {
		this.placetime = placetime;
	}

	public OrderMessage(String omid, String fno, String startplace, String endplace, double price, String time,
			String datetime, String name, String phone, String placetime) {
		super();
		this.omid = omid;
		this.fno = fno;
		this.startplace = startplace;
		this.endplace = endplace;
		this.price = price;
		this.time = time;
		this.datetime = datetime;
		this.name = name;
		this.phone = phone;
		this.placetime = placetime;
	}
	

}
