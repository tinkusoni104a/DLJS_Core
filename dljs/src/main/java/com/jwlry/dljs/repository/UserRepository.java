package com.jwlry.dljs.repository;

import com.jwlry.dljs.model.User;

public interface UserRepository extends BaseRepository<User>{

	User findByUserId(String userId);
	
}
