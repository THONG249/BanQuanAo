package com.shop.WebShop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.WebShop.Repository.CartRepository;
import com.shop.WebShop.model.Order;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/shopthoitrang")
public class CartController {
	@Autowired
	private CartRepository carttCartRepository;
	@PostMapping("/add-to-cart")
	public ResponseEntity<String> addCart(@RequestBody Order oder){
		try {
			carttCartRepository.create(new Order(oder.getUser_Id(),oder.getName(),oder.getDateBook(),oder.getDateReturn(),oder.getStatus(),oder.getQuantity(),oder.getAddress()));
			return new ResponseEntity<>("Thêm vào giỏ hàng thành công",HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Có lỗi khi thêm sản phẩm vào giỏ hàng",HttpStatus.BAD_REQUEST);
		}
			
	}
}
