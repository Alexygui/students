package com.aaa.entity;

import java.util.Date;

/**
 * 学生实体类
 */
public class Students {
	private String sid;//学号
	private String name;//姓名
	private String gender;//性别
	private Date birthday;//生日
	private String address;//地址
	public Students() {
	}
	public Students(String sid, String name, String gender, Date birthday, String address) {
		this.sid = sid;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Students [sid=" + sid + ", name=" + name + ", gender=" + gender + ", birthday=" + birthday
				+ ", address=" + address + "]";
	}
	
}
