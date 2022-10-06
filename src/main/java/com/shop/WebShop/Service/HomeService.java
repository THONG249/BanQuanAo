package com.shop.WebShop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shop.WebShop.Repository.HomeRepository;
import com.shop.WebShop.model.Brand;
import com.shop.WebShop.model.Product;
@Repository
public class HomeService implements HomeRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Product> lstProduct() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * from dboProduct", BeanPropertyRowMapper.newInstance(Product.class));

	}

	@Override
	public List<Brand> lstBrand() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * from dboBrand", BeanPropertyRowMapper.newInstance(Brand.class));

	}



}
