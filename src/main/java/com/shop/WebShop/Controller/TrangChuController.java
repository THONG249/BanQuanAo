package com.shop.WebShop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.shop.WebShop.Repository.HomeRepository;
import com.shop.WebShop.model.Brand;
import com.shop.WebShop.model.Category;
import com.shop.WebShop.model.Product;
import com.shop.WebShop.model.TrangChu;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/shopthoitrang")
public class TrangChuController {
	
	@Autowired
	private HomeRepository homeRepository;
	@GetMapping("/Trang-Chu")
	public ResponseEntity<TrangChu> Home(){
		
		List<Brand> lstBrandModels = homeRepository.lstBrand();
		List<Product> lstProductModels = homeRepository.lstProduct();
		List<Category> lstCategories = homeRepository.lstCategories();
		if(lstBrandModels != null && lstProductModels !=null) {
			return ResponseEntity.status(HttpStatus.OK).body(
					new TrangChu("Ok","Data is susscess",lstProductModels,lstBrandModels,lstCategories)
					);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new TrangChu("Not Found","Data is not exits", null, null,null)
					);
		}
	}
}
