package com.shop.WebShop.dto;

public class ResponseSigninDto {
	
private String status;
private String token;
private Object data;
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}
public ResponseSigninDto(String status, String token, Object data) {
	this.status = status;
	this.token = token;
	this.data = data;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
public ResponseSigninDto() {
}
}
