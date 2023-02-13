package com.jwlry.dljs.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwlry.dljs.model.User;
import com.jwlry.dljs.response.ApiResponse;
import com.jwlry.dljs.service.BaseService;
import com.jwlry.dljs.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController<User> {

	private final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private UserService userService;

	public UserController(BaseService<User> baseService) {
		super(baseService);
	}

	private void log(String line) {
		log.info(this.getClass() + "-->" + line);
		//System.out.println(this.getClass() + "-->" + line);
	}

	private void logErr(String line) {
		log.error(this.getClass() + "-->" + line);
		//System.out.println(this.getClass() + "-->" + line);
	}

	/*
	 * @PostMapping("/signup") public ApiResponse<User> signUp(@RequestBody User
	 * user) { log("in signUp()"); log(user.toString()); return
	 * userService.create(user);
	 * 
	 * }
	 */

}
