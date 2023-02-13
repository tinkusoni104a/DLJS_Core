package com.jwlry.dljs.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwlry.dljs.constants.ResponseMessage;
import com.jwlry.dljs.model.User;
import com.jwlry.dljs.repository.UserRepository;
import com.jwlry.dljs.response.ApiResponse;

@Service
public class UserService extends BaseService<User> {

	private final Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public UserService(UserRepository userRepository) {
		super(userRepository);
		this.userRepository = userRepository;
	}

	private void log(String line) {
		log.info(this.getClass() + "-->" + line);
		//System.out.println(this.getClass() + "-->" + line);
	}

	private void logErr(String line) {
		log.error(this.getClass() + "-->" + line);
		//System.out.println(this.getClass() + "-->" + line);
	}

	public ApiResponse<User> create(User user) {
		log("In create()");

//		if (userRepository.existsById(user.getUserId())) {
//			log.info(ResponseMessage.USER_ALREADY_EXISTS.getMessage());
//			return ApiResponse.failure(ResponseMessage.USER_ALREADY_EXISTS.getMessage());
//		}

		// encrypting the password

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		log(ResponseMessage.USER_CREATED.getMessage());
		return ApiResponse.success(ResponseMessage.USER_CREATED.getMessage(), user);

	}

}
