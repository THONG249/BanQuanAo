package com.shop.WebShop.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.shop.WebShop.Repository.ProductRepository;
import com.shop.WebShop.model.Product;
@Repository
public class ProductService implements ProductRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Product> products() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * from dboProduct", BeanPropertyRowMapper.newInstance(Product.class));
	}
	@Override
	public int create(Product product) {
		// TODO Auto-generated method stub
		String sqlString = "Insert into dboproduct (brand_Id,category_Id,product_Description,color,product_Size,quantity,price,image,name,material) values(?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sqlString,new Object[] {
				product.getBrand_Id(), product.getCategory_Id(), product.getProduct_Description(),product.getColor(),product.getProduct_Size(),
				product.getQuantity(),product.getPrice(),product.getImage(),product.getName(),product.getMaterial()
		});
	}	
}
