package com.shop.WebShop.model;

import java.sql.Date;


public class Comment {

	public Comment() {
		// TODO Auto-generated constructor stub
	}
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
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getAdmin_Content() {
		return Admin_Content;
	}
	public void setAdmin_Content(String admin_Content) {
		Admin_Content = admin_Content;
	}
	public Date getNgay_Comment() {
		return Ngay_Comment;
	}
	public void setNgay_Comment(Date ngay_Comment) {
		Ngay_Comment = ngay_Comment;
	}
	public Date getAdmin_Day() {
		return Admin_Day;
	}
	public void setAdmin_Day(Date admin_Day) {
		Admin_Day = admin_Day;
	}
	private int Id;
	private int User_Id;
	private String Content;
	private String Admin_Content;
	private Date Ngay_Comment;
	private Date Admin_Day;
	

}
