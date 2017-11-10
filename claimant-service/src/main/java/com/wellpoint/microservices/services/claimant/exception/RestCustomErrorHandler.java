package com.wellpoint.microservices.services.claimant.exception;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@RestControllerAdvice
/**
 * 
 * Controller Advice class for claimant
 *
 */
public class RestCustomErrorHandler {
	
	  @ExceptionHandler(value = { ClaimantException.class })
	  @ResponseStatus( org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
	public APIErrorResponse handleClaimantException(ClaimantException e, WebRequest webRequest) {
		
		String errorMsg = "Error occured while invoking " + webRequest.getDescription(false);
		return new APIErrorResponse(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getLocalizedMessage(),errorMsg);
		
	}

}
