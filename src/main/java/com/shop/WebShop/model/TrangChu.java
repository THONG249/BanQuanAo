package com.shop.WebShop.model;

import java.util.List;

public class TrangChu {

	private String statusString;
	private String messageString;
	public TrangChu(String statusString, String messageString, List<Product> lstProduct,
			List<Brand> lstBrand) {
		super();
		this.statusString = statusString;
		this.messageString = messageString;
		this.lstProduct = lstProduct;
		this.lstBrand = lstBrand;
	}
	public String getStatusString() {
		return statusString;
	}
	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}
	public String getMessageString() {
		return messageString;
	}
	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}
	public List<Product> getLstProduct() {
		return lstProduct;
	}
	public void setLstProduct(List<Product> lstProduct) {
		this.lstProduct = lstProduct;
	}
	public List<Brand> getLstBrand() {
		return lstBrand;
	}
	public void setLstBrand(List<Brand> lstBrand) {
		this.lstBrand = lstBrand;
	}
	private List<Product> lstProduct;
	private List<Brand> lstBrand;
	public TrangChu() {};
	
}
