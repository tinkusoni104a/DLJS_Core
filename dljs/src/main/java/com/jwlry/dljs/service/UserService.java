package com.jwlry.dljs.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwlry.dljs.constants.ResponseMessage;
import com.jwlry.dljs.model.User;
import com.jwlry.dljs.repository.UserRepository;
import com.jwlry.dljs.response.ApiResponse;

@Service
public class UserService implements UserDetailsService {

	private final Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findById(userId);
		if (user == null) {
			throw new UsernameNotFoundException(userId);
		}
		UserBuilder userBuilder = org.springframework.security.core.userdetails.User
				.withUsername(user.get().getUserId());
		userBuilder.password(bCryptPasswordEncoder.encode(user.get().getPassword()));
		userBuilder.roles(user.get().getRole());
		return userBuilder.build();
	}

	public ApiResponse<User> signUp(User user) {

		if (userRepository.existsById(user.getUserId())) {
			log.info(ResponseMessage.USER_ALREADY_EXISTS.getMessage());
			return ApiResponse.failure(ResponseMessage.USER_ALREADY_EXISTS.getMessage());
		}

		// encrypting the password
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		log.info(ResponseMessage.USER_CREATED.getMessage());
		return ApiResponse.succes(ResponseMessage.USER_CREATED.getMessage(), user);

	}

	

}
