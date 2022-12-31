package com.jwlry.dljs.constants;

import lombok.Getter;

public enum ResponseMessage {
	LOGIN_SUCCESS("Logged-in successfully"), 
	LOGIN_FAILED("Logged-in failed"),
	INVALID_CREDENTIALS("Invalid credentails, please check again"), 
	USER_NOT_FOUND("User_id not found. Kindly signup"),
	USER_ALREADY_EXISTS("User already exists"), 
	USER_CREATED("User created successfully");

	@Getter
	private String message;

	ResponseMessage(String message) {
		this.message = message;
	}
}
