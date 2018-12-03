package com.logmein.interview.badreddinesDemo.exceptions;

public class AppException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private int status;
	private String message;

	public AppException(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
