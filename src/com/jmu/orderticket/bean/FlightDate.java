package com.jmu.orderticket.bean;

public class FlightDate {
	private Integer fdid;
	private String date;
	private int number;
	private String ffid;

	public Integer getFdid() {
		return fdid;
	}

	public void setFdid(Integer fdid) {
		this.fdid = fdid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getFfid() {
		return ffid;
	}

	public void setFfid(String ffid) {
		this.ffid = ffid;
	}

	public FlightDate(Integer fdid, String date, int number, String ffid) {
		super();
		this.fdid = fdid;
		this.date = date;
		this.number = number;
		this.ffid = ffid;
	}

	public FlightDate() {
		super();
	}

	@Override
	public String toString() {
		return "FlightDate [fdid=" + fdid + ", date=" + date + ", number=" + number + ", ffid=" + ffid + "]";
	}
	

}
