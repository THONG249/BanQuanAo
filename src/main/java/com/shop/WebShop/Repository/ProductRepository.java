package com.shop.WebShop.Repository;

import java.util.List;
import com.shop.WebShop.model.Product;

public interface ProductRepository{

	List<Product> products(); 
	int create(Product product);
	Product finbyIdProduct (int id);
}
