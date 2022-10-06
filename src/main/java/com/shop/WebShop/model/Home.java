package com.shop.WebShop.model;

import java.util.List;

public class Home {
	
 private List<Product> productModel;
 public List<Product> getProductModel() {
	return productModel;
}
public void setProductModel(List<Product> productModel) {
	this.productModel = productModel;
}
public List<Brand> getBrandModel() {
	return brandModel;
}
public void setBrandModel(List<Brand> brandModel) {
	this.brandModel = brandModel;
}
private List<Brand> brandModel;
}
