package com.coinnect.CoinNect.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ContratoCannotBeCreatedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ContratoCannotBeCreatedException(String msg) {
		super(msg);
	}

	
	
}
