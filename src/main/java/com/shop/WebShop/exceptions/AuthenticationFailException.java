package com.shop.WebShop.exceptions;

public class AuthenticationFailException extends IllegalArgumentException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthenticationFailException(String message) {
		super(message);
	}
}
