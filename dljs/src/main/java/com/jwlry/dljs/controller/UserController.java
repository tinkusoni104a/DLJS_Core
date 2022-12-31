package com.jwlry.dljs.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwlry.dljs.dto.LoginAuthenticationRequestDTO;
import com.jwlry.dljs.model.User;
import com.jwlry.dljs.response.ApiResponse;
import com.jwlry.dljs.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private final Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public ApiResponse<User> signUp(@RequestBody User user) {
		log.info("Calling user service");
		log.info(user);
		return userService.signUp(user);

	}

}
