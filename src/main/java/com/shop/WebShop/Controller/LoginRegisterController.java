package com.shop.WebShop.Controller;




import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.WebShop.Repository.TokenRepository;
import com.shop.WebShop.Repository.UserRepository;
import com.shop.WebShop.dto.ResponseSigninDto;
import com.shop.WebShop.dto.SigninDto;
import com.shop.WebShop.exceptions.AuthenticationFailException;
import com.shop.WebShop.model.User;




@RestController
@RequestMapping("/shopthoitrang/register")
@CrossOrigin(origins = "http://localhost:8081")
public class LoginRegisterController {
	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private PasswordEncoder passwordEncoder;
	@Autowired
	private TokenRepository tokenRepository;

	

	@PostMapping(value = "/sign-up")
	public ResponseEntity<String> DangKy(@RequestBody User user) {   
		
			if(userRepository.findname(user.getUsername())) {
				return new ResponseEntity<>("Tên đăng nhập đã tồn tại",HttpStatus.BAD_REQUEST);
			}else {
				userRepository.create(new User(user.getUsername(), user.getFirstname(), user.getLastname(),
				passwordEncoder.encode(user.getPassword()), user.getEmail(), user.getPhone(), user.getRole_id()));		
		tokenRepository.createToken(user);
		return new ResponseEntity<>("Thành công", HttpStatus.CREATED);
			}
		

	}
	@PostMapping("/sign-in")
	public ResponseSigninDto singIn( @RequestBody SigninDto signdto) throws EmptyResultDataAccessException{
		//find user by user name
		BCryptPasswordEncoder b=new BCryptPasswordEncoder();
		
			User user = userRepository.getUser(signdto.getUsername());					
			if(Objects.isNull(user)) {
				throw new AuthenticationFailException("User is not valid");
			}
			if(!b.matches(signdto.getPassword(), user.getPassword())) {
				throw new AuthenticationFailException("Password is wrong");
			}
			String tokenString = tokenRepository.finByUsername(user);
			if(tokenString == null) {
				throw new AuthenticationFailException("Token is not present");
			}
			return new ResponseSigninDto("Succsess",tokenRepository.finByUsername(user),user);
					
	
	}

}
