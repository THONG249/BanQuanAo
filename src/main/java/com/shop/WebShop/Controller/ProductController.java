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

import org.springframework.web.bind.annotation.RestController;

import com.shop.WebShop.Repository.BrandRepository;
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
	@Autowired
	private BrandRepository brandRepository;

	@PostMapping("/create-product")
	public ResponseEntity<String> createNewProduct(@RequestBody Product product) {
		try {
			productRepository.create(
					new Product(product.getBrand_Id(), product.getCategory_Id(), product.getProduct_Description(),
							product.getColor(), product.getProduct_Size(), product.getQuantity(), product.getPrice(),
							product.getImage(), product.getName(), product.getMaterial()));
			return new ResponseEntity<>("Done", HttpStatus.CREATED);
		} catch (Exception e) {
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
	@GetMapping("/product-details/{id}")
	ResponseEntity<ResponseObject> getProductdetails(@PathVariable int id) {
		Optional<Product> productDeatails = Optional.ofNullable(productRepository.finbyIdProduct(id));
		Product product = productRepository.finbyIdProduct(id);
		Brand brand = brandRepository.findById(product.getBrand_Id());
		String brandName = brand.getName();
		if (productDeatails.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Ok", brandName, productDeatails));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseObject("Null", "Khong tim thay san pham voi id =" + id, null));
		}
	}
}
