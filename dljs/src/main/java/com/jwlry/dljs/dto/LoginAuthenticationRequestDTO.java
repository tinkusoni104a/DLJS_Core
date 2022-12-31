package com.jwlry.dljs.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class LoginAuthenticationRequestDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userId;
	private String password;
}
