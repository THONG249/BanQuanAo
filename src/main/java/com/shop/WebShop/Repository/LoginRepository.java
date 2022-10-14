package com.shop.WebShop.Repository;


import org.springframework.stereotype.Repository;

import com.shop.WebShop.model.User;

@Repository
public interface LoginRepository {
	 User findByUsername(String username);
}
