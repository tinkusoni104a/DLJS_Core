package com.jwlry.dljs.response;

import com.jwlry.dljs.constants.ResponseMessage;
import com.jwlry.dljs.constants.ResponseStatusCode;

import lombok.Data;

@Data
public class ApiResponse<T> {
	private int status;
	private String message;
	private T data;

	public ApiResponse(ResponseStatusCode status, String message, T data) {
		super();
		this.status = status.getStatus();
		this.message = message;
		this.data = data;
	}

	public static <T> ApiResponse<T> succes(String message, T data) {
		return new ApiResponse<T>(ResponseStatusCode.SUCCESS, message, data);

	}
	
	public static <T> ApiResponse<T> failure (String message) {

		return new ApiResponse<T>(ResponseStatusCode.FAILED, message, null);

	}



}
