package com.assignment.tasktwo.util;

public class CustomApiError {
	private String errorMessage;

	public CustomApiError(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
