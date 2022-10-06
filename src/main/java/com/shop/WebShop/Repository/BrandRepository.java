package com.shop.WebShop.Repository;

import java.util.List;

import com.shop.WebShop.model.Brand;

public interface BrandRepository{

	int create(Brand model);
	
	int delete(int id);
	
	Brand findById(int id);
	
	int update(Brand model);
	
	List<Brand> getAll();
	
	List<Brand> findByName(String name);

}
