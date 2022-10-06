package com.shop.WebShop.model;

import java.sql.Date;

public class Sale {

	public Sale() {
		// TODO Auto-generated constructor stub
	}
	private int Id;
	private int Product_Id;
	private float Sale_value;
	private Date sale_Date;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getProduct_Id() {
		return Product_Id;
	}
	public void setProduct_Id(int product_Id) {
		Product_Id = product_Id;
	}
	public float getSale_value() {
		return Sale_value;
	}
	public void setSale_value(float sale_value) {
		Sale_value = sale_value;
	}
	public Date getSale_Date() {
		return sale_Date;
	}
	public void setSale_Date(Date sale_Date) {
		this.sale_Date = sale_Date;
	}

}
