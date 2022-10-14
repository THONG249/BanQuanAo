package com.shop.WebShop.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shop.WebShop.Service.UserService;
import com.shop.WebShop.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userSv;


	@Override
	public UserDetails loadUserByUsername(String username) {
//		
		
//		User user = userRepository.findByUsername(username);
//		
//		UserBuilder userBuilder = null;
//		userBuilder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
//				.password(user.getPassword())
//				.roles(String.valueOf(user.getRole_id()));
//			
//		
//		return userBuilder.build();
		User user = userSv.findUser(username);
		
		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}

}
