package com.sapient.userservice.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.sapient.userservice.model.User;

@RepositoryRestResource
public interface UserRepository extends MongoRepository<User, String> {
	User findByUsername(String username);
}
