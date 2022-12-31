package com.jwlry.dljs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwlry.dljs.dto.LoginAuthenticationRequestDTO;
import com.jwlry.dljs.response.ApiResponse;
import com.jwlry.dljs.service.LoginAuthenticationService;
import com.jwlry.dljs.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	private LoginAuthenticationService loginAuthenticationService;
	
	@PostMapping("/authenticate")
	private ApiResponse<LoginAuthenticationRequestDTO> loginAuthenticate(
			@RequestBody LoginAuthenticationRequestDTO authenticationRequest) {

		return loginAuthenticationService.loginAuthenticate(authenticationRequest);
	}
	


}
