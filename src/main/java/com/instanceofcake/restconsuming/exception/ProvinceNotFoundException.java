package com.instanceofcake.restconsuming.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProvinceNotFoundException extends RuntimeException {

	public ProvinceNotFoundException(String message) {
		super(message);

	}
}
