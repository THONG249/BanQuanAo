package com.shop.WebShop.model;

public class Brand {
	private int id;
	private String name;
	private String address;
	private int phone;
	
	public Brand(int id, String name,int phone,String address) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;	
	}
	public Brand()
	{
	}
	public Brand(String name, int phone, String address) {
		this.name = name;
	this.phone = phone;
		this.address = address;
		}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}

}
