package com.jwlry.dljs.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import com.jwlry.dljs.dto.LoginAuthenticationRequestDTO;
import com.jwlry.dljs.response.ApiResponse;
import com.jwlry.dljs.utils.JwtTokenUtil;

@Service
public class LoginAuthenticationService {

	private final Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private AuthenticationManager authenticationManager;
	
	private JwtTokenUtil jwtTokenUtil;
	
	public ApiResponse<LoginAuthenticationRequestDTO> loginAuthenticate(
			LoginAuthenticationRequestDTO authenticationRequest) {
		logger.info("In loginAuthenticate method of class " + this.getClass());
		return null;
	}

}
