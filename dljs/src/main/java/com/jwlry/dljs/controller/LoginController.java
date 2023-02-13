package com.jwlry.dljs.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwlry.dljs.dto.LoginAuthenticationRequestDTO;
import com.jwlry.dljs.response.ApiResponse;
import com.jwlry.dljs.response.LoginAuthenticationResponseDTO;
import com.jwlry.dljs.service.LoginAuthenticationService;
import com.jwlry.dljs.service.LoginService;

@RestController
@RequestMapping("/api/login")
public class LoginController {

	private final Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private LoginService loginService;

	@Autowired
	private LoginAuthenticationService loginAuthenticationService;

	private void log(String line) {
		log.info(this.getClass() + "-->" + line);
		//System.out.println(this.getClass() + "-->" + line);
	}

	private void logErr(String line) {
		log.error(this.getClass() + "-->" + line);
		//System.out.println(this.getClass() + "-->" + line);
	}

	@PostMapping("/authenticate")
	private ApiResponse<LoginAuthenticationResponseDTO> loginAuthenticate(
			@RequestBody LoginAuthenticationRequestDTO authenticationRequest) {
		log("loginAuthenticate()");
		return loginAuthenticationService.loginAuthenticate(authenticationRequest);
	}

}
