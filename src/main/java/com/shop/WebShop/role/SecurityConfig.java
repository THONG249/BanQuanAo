package com.shop.WebShop.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Autowired
    private CustomUserDetailsService userSv;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http.cors().and() .csrf().disable() ;
    	
      return http.build();
    }

    


    @Bean
    public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
    	AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class) ;
    	auth.userDetailsService(userSv)
        .passwordEncoder(passwordEncoder());
        return auth.build();
    }
}