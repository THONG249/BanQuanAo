package com.shop.WebShop.model;

public class OrderDetails {

	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}
	private int Id;
	private int Order_Id;
	private int Product_Id;
	private int Quantity;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getOrder_Id() {
		return Order_Id;
	}
	public void setOrder_Id(int order_Id) {
		Order_Id = order_Id;
	}
	public int getProduct_Id() {
		return Product_Id;
	}
	public void setProduct_Id(int product_Id) {
		Product_Id = product_Id;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	

}
