package com.shop.WebShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class WebShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebShopApplication.class, args);
	}
	
	private final class WebmvcConfigurerAdapterExtension extends WebMvcConfigurerAdapter
	{
		@Override
		public void addCorsMappings(CorsRegistry corsRegistry)
		{
			corsRegistry.addMapping("/**").allowedOrigins("http://localhost:8080");
		}
		
		
	}
	@Bean
	public WebMvcConfigurer corsConfigurer()
	{
		return new WebmvcConfigurerAdapterExtension();
	}

}
