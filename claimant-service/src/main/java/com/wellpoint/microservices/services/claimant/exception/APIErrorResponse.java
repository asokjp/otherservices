package com.wellpoint.microservices.services.claimant.exception;

import java.util.Arrays;
import java.util.List;

/**
 * API Error response class for claimant 
 * 
 *
 */
public class APIErrorResponse {
	private int httpStatus;
    private String message;
    private List<String> errors;
 
    public APIErrorResponse(int httpStatus, String message, List<String> errors) {
        super();
        this.httpStatus = httpStatus;
        this.message = message;
        this.errors = errors;
    }
 
    public APIErrorResponse(int httpStatus, String message, String error) {
         super();
        this.httpStatus = httpStatus;
        this.message = message;
        errors = Arrays.asList(error);
    }

}
