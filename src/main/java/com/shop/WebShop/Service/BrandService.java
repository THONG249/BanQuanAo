package com.shop.WebShop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.shop.WebShop.Repository.BrandRepository;
import com.shop.WebShop.model.Brand;


@Repository
public class BrandService implements BrandRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int create(Brand model) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("INSERT INTO dboBrand (name,phone,address) VALUES (?,?,?)",
				new Object[] {model.getName(),model.getPhone(), model.getAddress()});
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int update(Brand model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * from dbocBrand", BeanPropertyRowMapper.newInstance(Brand.class));
	}

	@Override
	public Brand findById(int id) {
		// TODO Auto-generated method stub
		try {
		      Brand brand = jdbcTemplate.queryForObject("SELECT * FROM dboBrand WHERE Id=?",
		          BeanPropertyRowMapper.newInstance(Brand.class), id);

		      return brand;
		    } catch (IncorrectResultSizeDataAccessException e) {
		      return null;
		    }
	}

	@Override
	public List<Brand> findByName(String name) {
		// TODO Auto-generated method stub
		String q = "SELECT * from dbocBrand WHERE Name LIKE '%" + name + "%' collate binary_ci";
		return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Brand.class));
	}

}
