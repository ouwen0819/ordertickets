package com.jmu.orderticket.bean;

public class Flight {
	private Integer fid;
	private String fno;
	private String startplace;
	private String endplace;
	private String time;
	private double price;

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Flight(Integer fid, String fno, String startplace, String endplace, String time, double price) {
		super();
		this.fid = fid;
		this.fno = fno;
		this.startplace = startplace;
		this.endplace = endplace;
		this.time = time;
		this.price = price;
	}

	public Flight() {
		super();
	}

}
