package com.wellpoint.microservices.services.claimant.exception;

public class ClaimantException extends Exception {

	/**
	 * Exception class for claimant
	 */
	private static final long serialVersionUID = 8661271303934976718L;
	
	public ClaimantException()
	{
		super();
	}
	
	public ClaimantException(String errorDescription, String errorCode,Throwable th)
	{
		super();
		this.errorDescription = errorDescription;
		this.errorCode = errorCode;
		this.throwable = th;
	}
	
	private String errorDescription;
	private String errorCode;
	private Throwable throwable;
	
	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	

}
