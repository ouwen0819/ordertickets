package com.jmu.orderticket.bean;

public class UserMessage {
	private Integer umid;
	private String name;
	private int age;
	private String sex;
	private String idcard;
	private String birthdate;
	private String uuid;

	public Integer getUmid() {
		return umid;
	}

	public void setUmid(Integer umid) {
		this.umid = umid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public UserMessage(Integer umid, String name, int age, String sex, String idcard, String birthdate, String uuid) {
		super();
		this.umid = umid;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.idcard = idcard;
		this.birthdate = birthdate;
		this.uuid = uuid;
	}

	public UserMessage() {
		super();
	}

}
