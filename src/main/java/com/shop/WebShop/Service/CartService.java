package com.shop.WebShop.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shop.WebShop.Repository.CartRepository;
import com.shop.WebShop.model.Order;

@Repository
public class CartService implements CartRepository{
	@Autowired JdbcTemplate jdbcTemplate;

	@Override
	public int create(Order oder) {

		String sql = "insert into dboOrder (User_Id,Name,DateBook,DateReturn,Status,Quantity,Address) values (?,?,?,?,?,?,?)";		
		return jdbcTemplate.update(sql,new Object[] {oder.getUser_Id(),oder.getName(),oder.getDateBook(),oder.getDateReturn(),oder.getStatus(),oder.getQuantity(),oder.getAddress()});
	}

}
