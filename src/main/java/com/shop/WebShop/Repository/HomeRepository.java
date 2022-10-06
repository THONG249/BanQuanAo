package com.shop.WebShop.Repository;

import java.util.List;



import com.shop.WebShop.model.Brand;
import com.shop.WebShop.model.Product;


public interface HomeRepository {
	List<Product> lstProduct();
	List<Brand> lstBrand();
}
