package com.shop.WebShop.model;

import java.util.Date;


public class AuthenticationToken {
	private int id;
	private String token;
	private Date create_date;
	private int user_id;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
//	public AuthenticationToken(User user) {
//		this.user = user;
//		this.create_date = new Date();
//		this.token = UUID.randomUUID().toString();
//		}

	public AuthenticationToken(String token, Date create_date, int user_id) {
		super();
		this.token = token;
		this.create_date = create_date;
		this.user_id = user_id;

	}

	public AuthenticationToken(int id, String token, Date create_date, int user_id) {
		super();
		this.id = id;
		this.token = token;
		this.create_date = create_date;
		this.user_id = user_id;
	}

	public AuthenticationToken() {
		super();
	}
}
