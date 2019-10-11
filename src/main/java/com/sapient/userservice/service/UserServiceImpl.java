package com.sapient.userservice.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.stereotype.Service;

import com.sapient.userservice.dao.UserRepository;
import com.sapient.userservice.exception.UserNotfoundException;
import com.sapient.userservice.model.User;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository ;
	
	@Override
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) {
//		user.set_id(ObjectId.get());
		System.out.println("-------");
		System.out.println(user);		
		return userRepository.save(user);
		
	}

	@Override
	public User getUserByUsername(String username) {
		User dummy =  userRepository.findByUsername(username);
//		Optional<User> dummy = userRepository.findById(userId);
//		if(!dummy.isPresent())throw new UserNotfoundException();
		return dummy;

	}

	@Override
	public User updateUser(User user) {
		 user.set_id(ObjectId.get());
		 User dummyuser = userRepository.findByUsername(user.getUsername());
		
		 System.out.println("user name is = " + dummyuser.getUsername());
//		 if(!dummyuser.isPresent())throw new UserNotfoundException();
//		 else {
//			User dummyuser = dummy.get();	
			
			dummyuser.setAddress(user.getAddress());
			dummyuser.setEmail(user.getEmail());
			dummyuser.setPhoneNumber(user.getPhoneNumber());
			dummyuser.setFundTransactionLimit(user.getFundTransactionLimit());
			dummyuser.setChannelPreference(user.getChannelPreference());
			return userRepository.save(dummyuser);
//		}
		  
		
	}
	 
}
