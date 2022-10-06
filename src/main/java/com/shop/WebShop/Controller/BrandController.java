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

import com.shop.WebShop.Repository.BrandRepository;
import com.shop.WebShop.model.Brand;
import com.shop.WebShop.model.ResponseObject;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/shopthoitrang")
public class BrandController {
	@Autowired
	BrandRepository brandRepository;

	@PostMapping("/Create-Brand")
	public ResponseEntity<String> Create_New_Brand(@RequestBody Brand brand) {
		try {
			brandRepository.create(new Brand(brand.getName(), brand.getPhone(), brand.getAddress()));
			return new ResponseEntity<>("Done", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/get/{id}")
	ResponseEntity<ResponseObject> getAll(@PathVariable int id) {
		Optional<Brand> brandOptional = Optional.ofNullable(brandRepository.findById(id));
		if (brandOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Ok", "Tìm thấy data:", brandOptional));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseObject("Null", "Khong tim thay san pham voi id =" + id, null));
		}
	}

	@GetMapping("/list-brand")
	public ResponseEntity<List<Brand>> getList(@RequestParam(required = false) String name) {
		List<Brand> x = new ArrayList<Brand>();
		try {
			if (name == null)
				brandRepository.getAll().forEach(x::add);
			else
				brandRepository.findByName(name).forEach(x::add);

			if (x.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(x, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
