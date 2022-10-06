package com.shop.WebShop.Repository;


import com.shop.WebShop.model.User;
import java.util.List;
import java.util.Optional;




public interface UserRepository{
	User getData(int id);
	boolean findname(String username);
   int create (User user);
   List<User>findByName(String username);
   User getUser(String username);
}
