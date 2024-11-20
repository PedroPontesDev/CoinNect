package com.coinnect.CoinNect.exceptions.handler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.coinnect.CoinNect.exceptions.ContratoCannotBeCreatedException;
import com.coinnect.CoinNect.exceptions.ExceptionResponse;
import com.coinnect.CoinNect.exceptions.ResourceNotFoundException;
import com.coinnect.CoinNect.exceptions.UnsoportedEvaluationException;

@ControllerAdvice
@RestController
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleResourceNotFound(ResourceNotFoundException ex,
			WebRequest request) {
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ContratoCannotBeCreatedException.class)
	public final ResponseEntity<ExceptionResponse> handleContratoCannotBeCreateExceptio(ContratoCannotBeCreatedException ex , WebRequest request) {
		ExceptionResponse exResponse = new ExceptionResponse(new Date(), 
				ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UnsoportedEvaluationException.class)
	public final ResponseEntity<ExceptionResponse> handleEvaluationUnsuportedExceptio(UnsoportedEvaluationException ex , WebRequest request) {
		ExceptionResponse exResponse = new ExceptionResponse(new Date(), 
				ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exResponse, HttpStatus.BAD_REQUEST);
	}
	

}
