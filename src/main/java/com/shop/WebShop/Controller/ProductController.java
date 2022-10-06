package com.shop.WebShop.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.WebShop.Repository.ProductRepository;
import com.shop.WebShop.model.Brand;
import com.shop.WebShop.model.Product;
import com.shop.WebShop.model.ResponseObject;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/shopthoitrang")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	@PostMapping("/create-product")
	public ResponseEntity<String> createNewProduct(@RequestBody Product product){
		try {
			productRepository.create(new Product(
					product.getBrand_Id(), product.getCategory_Id(), product.getProduct_Description(),product.getColor(),product.getProduct_Size(),
					product.getQuantity(),product.getPrice(),product.getImage(),product.getName(),product.getMaterial()));
			return new ResponseEntity<>("Done", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.toString());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@GetMapping("/list-product")
	public ResponseEntity<List<Product>> getList() {
		List<Product> x = new ArrayList<Product>();
		try {	
				productRepository.products().forEach(x::add);			
			return new ResponseEntity<>(x, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
