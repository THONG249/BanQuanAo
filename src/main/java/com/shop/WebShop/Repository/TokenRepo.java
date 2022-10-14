package com.shop.WebShop.Repository;


import org.springframework.stereotype.Repository;

import com.shop.WebShop.model.AuthenticationToken;
import com.shop.WebShop.model.User;

@Repository
public interface TokenRepo {
	AuthenticationToken findByUser(User user);
}
