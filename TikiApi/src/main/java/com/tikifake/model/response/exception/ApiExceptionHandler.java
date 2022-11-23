package com.tikifake.model.response.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handlerNotFound(NotFoundException ex, WebRequest req) {
		return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
	}
	
	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handlerBadRequest(BadRequestException ex, WebRequest req) {
		return new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
	}
	
}
