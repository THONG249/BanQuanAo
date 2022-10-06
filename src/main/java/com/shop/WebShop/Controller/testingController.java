package com.shop.WebShop.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.WebShop.Repository.UserRepository;
import com.shop.WebShop.model.User;

@RestController
@RequestMapping("/shopthoitrang/api")
@CrossOrigin(origins = "http://localhost:8081")
public class testingController {

	@Autowired
	UserRepository userrepo;
	
	
	@GetMapping("/test/{id}")
	public User getAll(@PathVariable int id){
		User brandOptional = userrepo.getData(id);
		return brandOptional;
	}

}
