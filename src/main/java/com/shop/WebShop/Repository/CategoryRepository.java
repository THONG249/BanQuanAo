package com.shop.WebShop.Repository;

import java.util.List;

import com.shop.WebShop.model.Category;


public interface CategoryRepository{
	int create(Category model);

	int update(Category model);

	List<Category> findByName(String Name);
	Category finById(int Id);

	int deleteById(int Id);

	List<Category> getAll();
}
