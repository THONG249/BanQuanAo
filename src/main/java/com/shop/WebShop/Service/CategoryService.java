package com.shop.WebShop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shop.WebShop.Repository.CategoryRepository;
import com.shop.WebShop.model.Category;

@Repository
public class CategoryService implements CategoryRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Category categoryModel) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("INSERT INTO dboCategory(name) VALUES(?)",
				new Object[] { categoryModel.getName() });
	}

	@Override
	public int update(Category model) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("UPDATE dboCategory SET Name=? WHERE Id=?",
				new Object[] { model.getName(), model.getId() });
	}

	@Override
	public List<Category> findByName(String Name) {
		// TODO Auto-generated method stub
		String q = "SELECT * from dbocategory WHERE Name LIKE '%" + Name + "%' collate binary_ci";
		return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Category.class));
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM dbocategory WHERE id=?", id);
	}

	@Override
	public List<Category> getAll() {
		return jdbcTemplate.query("SELECT * from dbocategory", BeanPropertyRowMapper.newInstance(Category.class));
	}

	@Override
	public Category finById(int Id) {
		try {
		      Category category = jdbcTemplate.queryForObject("SELECT * FROM dbocategory WHERE Id=?",
		          BeanPropertyRowMapper.newInstance(Category.class), Id);

		      return category;
		    } catch (IncorrectResultSizeDataAccessException e) {
		      return null;
		    }
	}

}
