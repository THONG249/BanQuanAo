package com.shop.WebShop.dto;

public class ResponseSigninDto {
private String status;
private String token;
public ResponseSigninDto(String status, String token) {
	this.status = status;
	this.token = token;
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
