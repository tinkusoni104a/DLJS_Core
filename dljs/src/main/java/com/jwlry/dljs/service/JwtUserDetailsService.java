package com.jwlry.dljs.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwlry.dljs.constants.ResponseMessage;
import com.jwlry.dljs.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	private final Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

	private void log(String line) {
		log.info(this.getClass() + "-->" + line);
		//System.out.println(this.getClass() + "-->" + line);
	}

	private void logErr(String line) {
		log.error(this.getClass() + "-->" + line);
		//System.out.println(this.getClass() + "-->" + line);
	}

	@SuppressWarnings("unused")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log("In loadUserByUsername()");
		log("username : " + username);
		com.jwlry.dljs.model.User users = userRepository.findByUserId(username);
		log("users.toString() :  " + users.toString());
		log("password : " + users.getPassword());
		if (users != null) {
			return new User(users.getUserId(), users.getPassword(), new ArrayList<>());

		} else {
			throw new UsernameNotFoundException(ResponseMessage.USER_NOT_FOUND.getMessage() + username);
		}

	}
}
