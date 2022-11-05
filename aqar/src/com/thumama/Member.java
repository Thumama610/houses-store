package com.thumama;

import java.sql.SQLException;

public class Member {
	private String fname;
	private String lname;
	private String email;
	private String phone;
	private String city;
	private String username;
	private String password;
	private int id;
	
	public Member(String username,String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Member(String fname, String lname, String email, String phone, String city, String username,
			String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.username = username;
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() throws ClassNotFoundException, SQLException {
		return MembersDao.getId(username);
	}

}
