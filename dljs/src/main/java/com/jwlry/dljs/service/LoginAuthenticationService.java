package com.jwlry.dljs.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwlry.dljs.constants.EnumData;
import com.jwlry.dljs.constants.ResponseMessage;
import com.jwlry.dljs.dto.LoginAuthenticationRequestDTO;
import com.jwlry.dljs.model.User;
import com.jwlry.dljs.repository.UserRepository;
import com.jwlry.dljs.response.ApiResponse;
import com.jwlry.dljs.response.LoginAuthenticationResponseDTO;
import com.jwlry.dljs.utils.JwtTokenUtil;

@Service
public class LoginAuthenticationService {

	private final Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

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

	public ApiResponse<LoginAuthenticationResponseDTO> loginAuthenticate(
			LoginAuthenticationRequestDTO authenticationRequest) {
		log("In loginAuthenticate()");
		log("authenticationRequest :" + authenticationRequest);
		// System.out.println("In loginAuthenticate method of class :" +
		// this.getClass());
		// System.out.println("authenticationRequest : " + authenticationRequest);
		LoginAuthenticationResponseDTO response = new LoginAuthenticationResponseDTO();

		try {
			log("authenticationRequest.toString() : " + authenticationRequest.toString());

			final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getUserId());

			authenticate(authenticationRequest.getUserId(), authenticationRequest.getPassword());

			final String token = jwtTokenUtil.generateToken(userDetails);
			User user = userRepository.findByUserId(userDetails.getUsername());
			log("User : " + user);
			if (user.getUserStatus().equalsIgnoreCase(EnumData.ENABLED.getStatus())) {
				log("Indide if");
				response.setToken(token);
				response.setUserName(user.getUserName());
				// response.setChangePassword(user.getChgPassFlg());
				return ApiResponse.success(ResponseMessage.LOGIN_SUCCESS.getMessage(), response);
			} else if (user.getUserStatus().equalsIgnoreCase(EnumData.LOCKED.getStatus())) {
				return ApiResponse.failure(ResponseMessage.USER_LOCKED.getMessage());
			} else if (user.getUserStatus().equalsIgnoreCase(EnumData.DISABLED.getStatus())) {
				return ApiResponse.failure(ResponseMessage.USER_DISABLED.getMessage());
			}

			log("out of loginAuthenticate()");

		} catch (BadCredentialsException e) {
			logErr("e.getMessage() : " + e.getMessage());
			return ApiResponse.failure(ResponseMessage.INVALID_CREDENTIALS.getMessage());

		} catch (UsernameNotFoundException e) {

			logErr("e.getMessage() : " + e.getMessage());
			return ApiResponse.failure(ResponseMessage.USER_NOT_FOUND.getMessage());

		} catch (Exception e) {
			logErr("e.getMessage() : " + e.getMessage());
			return ApiResponse.failure(ResponseMessage.LOGIN_FAILED.getMessage());
		}

		return null;
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			log("In authenticate() ");
			log("username" + username + " , password : " + password);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			logErr(e.getMessage());
			throw new Exception(ResponseMessage.USER_DISABLED.getMessage(), e);
		} catch (BadCredentialsException e) {
			logErr(e.getMessage());
			throw new BadCredentialsException(ResponseMessage.INVALID_CREDENTIALS.getMessage(), e);
		}
	}

}
