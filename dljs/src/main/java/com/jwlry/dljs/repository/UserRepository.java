package com.jwlry.dljs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwlry.dljs.model.User;

public interface UserRepository extends BaseRepository<User>{

	Optional<User> findById(String userId);

}
