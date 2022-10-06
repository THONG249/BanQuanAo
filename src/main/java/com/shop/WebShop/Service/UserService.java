package com.shop.WebShop.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import com.shop.WebShop.Repository.UserRepository;
import com.shop.WebShop.model.AuthenticationToken;
import com.shop.WebShop.model.Brand;
import com.shop.WebShop.model.User;

@Repository
public class UserService implements UserRepository{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public User getData(int id) {
		String sqlString = "select *from dboUser join Quyen on dboUser.role_id = Quyen.id where dbouser.id='"+id+"'";
		return jdbcTemplate.query(sqlString,new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user =new User();
				while(rs.next()) {
					user.setId(rs.getInt("id"));
					user.setRole_id(rs.getInt("role_id"));
					user.setUsername(rs.getString("username"));
					user.setEmail(rs.getString("email"));
					user.setFirstname(rs.getString("firstname"));
					user.setLastname(rs.getString("lastname"));
					user.setPassword(rs.getString("password"));
					user.setPhone(rs.getInt("phone"));
					user.setRoles(new SimpleGrantedAuthority(rs.getString("name")));
				}
				return user;
			}
			
		});
	}
	
public User findUser(String username) {
	String sqlString = "select *from dboUser join Quyen on dboUser.role_id = Quyen.id where dbouser.username='"+username+"'";
	return jdbcTemplate.query(sqlString,new ResultSetExtractor<User>() {

		public User extractData(ResultSet rs) throws SQLException, DataAccessException {
			User user =new User();
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setRole_id(rs.getInt("role_id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getInt("phone"));
				user.setRoles(new SimpleGrantedAuthority(rs.getString("name")));
			}
			return user;
		}
		
	});
}

	@Override
	public boolean findname(String username) {

		String findName = "SELECT username from dboUser WHERE username LIKE '%" + username + "%' collate binary_ci";
		try {
			jdbcTemplate.queryForObject(findName, BeanPropertyRowMapper.newInstance(User.class));
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
		return true;
	}
	@Override
	public int create(User user) {
		return jdbcTemplate.update("INSERT INTO dbouser (username,firstname,lastname,password,email,phone,role_id) VALUES (?,?,?,?,?,?,?)",
				new Object[] {user.getUsername(),user.getFirstname(),user.getLastname(),user.getPassword(),user.getEmail(),user.getPhone(),user.getRole_id()});
	}

	@Override
	public List<User> findByName(String username) {
		String q = "SELECT * from dboUser WHERE username LIKE '%" + username + "%' collate binary_ci";
		return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(User.class));
	}

	@Override
	public User getUser(String username) {
		try {
			String tokenString = "Select *from dboUser where username like '" + username + "' FETCH FIRST 1 ROWS ONLY";
			User user =  jdbcTemplate.queryForObject(tokenString, BeanPropertyRowMapper.newInstance(User.class));
			return user;
		} catch (Exception e) {
			return null;
		}
	}

}
