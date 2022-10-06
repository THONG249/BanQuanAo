package com.shop.WebShop.Repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.shop.WebShop.model.AuthenticationToken;
import com.shop.WebShop.model.User;

@EnableJpaRepositories
public interface TokenRepository{
 int createToken(User user);
 String finByUsername(User user);
 AuthenticationToken token(User user);
}
