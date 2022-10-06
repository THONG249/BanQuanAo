
package com.shop.WebShop.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.shop.WebShop.Repository.CategoryRepository;
import com.shop.WebShop.Repository.UserRepository;
import com.shop.WebShop.model.Category;
import com.shop.WebShop.model.User;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/shopthoitrang")
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;
	@GetMapping("/api")
	public ResponseEntity<List<Category>> getAllCategory(@RequestParam(required = false) String name) {
		List<Category> x = new ArrayList<Category>();
		try {
			if (name == null)
				categoryRepository.getAll().forEach(x::add);
			else
				categoryRepository.findByName(name).forEach(x::add);

			if (x.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(x, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/api")
	public ResponseEntity<String> createCategory(@RequestBody Category model) {
		try {
			categoryRepository.create(new Category(model.getName()));
			return new ResponseEntity<>("Thêm mới thành công", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/api/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") int id) {
		int result = categoryRepository.deleteById(id);
		try {
			if (result == 0) {
				return new ResponseEntity<>("Không thể tìm thấy id=" + id, HttpStatus.OK);
			}
			return new ResponseEntity<>("Xóa thành công.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Không thể xóa.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//sửa item follow id
	 @PutMapping("/api/{id}")
	  public ResponseEntity<String> updateCategory(@PathVariable("id") int id, @RequestBody Category category) {
	    Category _category = categoryRepository.finById(id);

	    if (_category != null) {
	    	_category.setId(id);
	    	_category.setName(category.getName());

	    	categoryRepository.update(_category);
	      return new ResponseEntity<>("Category was updated successfully.", HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>("Category find Tutorial with id=" + id, HttpStatus.NOT_FOUND);
	    }
	  }
}