package com.shop.WebShop.model;

import java.sql.Date;
import java.util.List;

public class Order {

	public Order(int user_Id, String name, Date dateBook, Date dateReturn, String status, int quantity,
			String address) {
		super();
		User_Id = user_Id;
		Name = name;
		DateBook = dateBook;
		DateReturn = dateReturn;
		Status = status;
		Quantity = quantity;
		Address = address;
	}
	public Order(int id, int user_Id, String name, Date dateBook, Date dateReturn, String status, int quantity,
			String address) {
		super();
		Id = id;
		User_Id = user_Id;
		Name = name;
		DateBook = dateBook;
		DateReturn = dateReturn;
		Status = status;
		Quantity = quantity;
		Address = address;
	}
	public Order(int id, int user_Id, String name, Date dateBook, Date dateReturn, String status, int quantity,
			String address, List<OrderDetails> lstOrderDetails) {
		super();
		Id = id;
		User_Id = user_Id;
		Name = name;
		DateBook = dateBook;
		DateReturn = dateReturn;
		Status = status;
		Quantity = quantity;
		Address = address;
		this.lstOrderDetails = lstOrderDetails;
	}
	public Order(int user_Id, String name, Date dateBook, Date dateReturn, String status, int quantity, String address,
			List<OrderDetails> lstOrderDetails) {
		super();
		User_Id = user_Id;
		Name = name;
		DateBook = dateBook;
		DateReturn = dateReturn;
		Status = status;
		Quantity = quantity;
		Address = address;
		this.lstOrderDetails = lstOrderDetails;
	}
	public Order() {
		// TODO Auto-generated constructor stub
	}
	private int Id;
    private int User_Id;
    private String Name;
    private Date DateBook;
    private Date DateReturn;
    private String Status;
    private int Quantity;
    private String Address;
    private List<OrderDetails>lstOrderDetails ;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getDateBook() {
		return DateBook;
	}
	public void setDateBook(Date dateBook) {
		DateBook = dateBook;
	}
	public Date getDateReturn() {
		return DateReturn;
	}
	public void setDateReturn(Date dateReturn) {
		DateReturn = dateReturn;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public List<OrderDetails> getLstOrderDetails() {
		return lstOrderDetails;
	}
	public void setLstOrderDetails(List<OrderDetails> lstOrderDetails) {
		this.lstOrderDetails = lstOrderDetails;
	}

}
