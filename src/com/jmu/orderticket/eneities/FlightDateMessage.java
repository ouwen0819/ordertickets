package com.jmu.orderticket.eneities;

public class FlightDateMessage {
	private String fno;
	private String startplace;
	private String endplace;
	private double price;
	private String time;
	private int number;
	private String date;

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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public FlightDateMessage(String fno, String startplace, String endplace, double price, String time, int number,
			String date) {
		super();
		this.fno = fno;
		this.startplace = startplace;
		this.endplace = endplace;
		this.price = price;
		this.time = time;
		this.number = number;
		this.date = date;
	}

	public FlightDateMessage() {
		super();
	}

}
