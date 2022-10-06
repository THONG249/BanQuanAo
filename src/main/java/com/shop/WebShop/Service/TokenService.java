package com.shop.WebShop.Service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.shop.WebShop.Repository.TokenRepository;
import com.shop.WebShop.model.AuthenticationToken;
import com.shop.WebShop.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Repository
public class TokenService implements TokenRepository{
	@Autowired
	private JdbcTemplate _jdbcJdbcTemplate;
	@Override
	public int createToken(User user) {
		Date now = new Date();
		Date enDate = new Date(now.getTime() + 604800000L);
	String tokenString = Jwts.builder().setSubject(String.valueOf(user.getId())).setIssuedAt(now).setExpiration(enDate).signWith(SignatureAlgorithm.HS512, "sdfsddsf").compact();
	String sqlString = "insert into Authentication_Token(token,create_date,user_id) values (?,?,?)";
	User id_user = _jdbcJdbcTemplate.queryForObject("select * from dbouser where username LIKE '" + user.getUsername() + "' FETCH FIRST 1 ROWS ONLY" , BeanPropertyRowMapper.newInstance(User.class));
	return _jdbcJdbcTemplate.update(sqlString,new Object[] {tokenString,now,id_user.getId()});
	}
	@Override
	public String finByUsername(User user) {
		User id_user = _jdbcJdbcTemplate.queryForObject("select * from dbouser where username LIKE '" + user.getUsername() + "' FETCH FIRST 1 ROWS ONLY" , BeanPropertyRowMapper.newInstance(User.class));
		String token = "Select *from Authentication_Token where user_id LIKE '" + id_user.getId() + "' FETCH FIRST 1 ROWS ONLY";
		AuthenticationToken tokenAu =  _jdbcJdbcTemplate.queryForObject(token, BeanPropertyRowMapper.newInstance(AuthenticationToken.class));
		return tokenAu.getToken();
	}
	@Override
	public AuthenticationToken token(User user) {
		String tokenString = "Select *from dboUser where username '" + user.getUsername() + "' ETCH FIRST 1 ROWS ONLY";
		return _jdbcJdbcTemplate.queryForObject(tokenString, BeanPropertyRowMapper.newInstance(AuthenticationToken.class));
	}
}
