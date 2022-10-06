//package com.shop.WebShop.Service;
//
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.Objects;
//
//import javax.transaction.Transactional;
//import javax.xml.bind.DatatypeConverter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.shop.WebShop.Repository.LoginRepository;
//import com.shop.WebShop.dto.ResponseSigninDto;
//import com.shop.WebShop.dto.SigninDto;
//import com.shop.WebShop.exceptions.AuthenticationFailException;
//import com.shop.WebShop.exceptions.CustomException;
//import com.shop.WebShop.model.AuthenticationToken;
//import com.shop.WebShop.model.User;
//
//@Service
//public class LogInService {
////	@Autowired
////	LoginRepository loginRepository;
//	@Autowired
//	AuthenticationTokenService authenticationTokenService;
//	private String hashPassword(String password) throws NoSuchAlgorithmException {
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        md.update(password.getBytes());
//        byte[] digest = md.digest();
//        String hash = DatatypeConverter
//                .printHexBinary(digest).toUpperCase();
//        return hash;
//    }
////	@Transactional
////	 public ResponseSigninDto signIn(User user) {
////	        // find user by email
////
////	       
////
////	        // compare the password in DB
////
////	        // if password match
////
//////	        AuthenticationToken token = authenticationTokenService.getToken(user);
////
////	        // retrive the token
////
////	        if (Objects.isNull(token)) {
////	            throw new CustomException("token is not present");
////	        }
////
////	        return new ResponseSigninDto("sucess", token.getToken());
////
////	        // return response
////	    }
//}
