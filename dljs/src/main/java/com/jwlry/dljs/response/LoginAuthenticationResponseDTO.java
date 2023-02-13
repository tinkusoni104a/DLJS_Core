package com.jwlry.dljs.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginAuthenticationResponseDTO {

	public LoginAuthenticationResponseDTO() {
		super();
	}

	private String token;
	private Boolean changePassword;
	private String userName;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(Boolean changePassword) {
		this.changePassword = changePassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "LoginAuthenticationResponseDTO [token=" + token + ", changePassword=" + changePassword + ", userName="
				+ userName + "]";
	}

}
