package com.sapient.userservice.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.doReturn;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.sapient.userservice.dao.UserRepository;
import com.sapient.userservice.model.Address;
import com.sapient.userservice.model.User;
import static org.mockito.Mockito.when;




@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testgetAllUsers(){
		List<User> userList = new ArrayList<User>();
		ArrayList<String> demochannel = new ArrayList<>();
		demochannel.add("SMS");
		Address demoaddress = new  Address("A-199","mg road","jaipur","rajasthan",Integer.valueOf("241412"));
		
		userList.add(new User("shivani","sha@gmail.com",
				7643456789L,demoaddress,
				3123214219989L,demochannel
				));
		userList.add(new User("vani","ha@gmail.com",
				9643456789L,demoaddress,
				9123214219989L,demochannel
				));
		when(userRepository.findAll()).thenReturn(userList);	
		List<User> result = userService.getAllUsers();
		assertEquals(2, result.size());
	}
	
	@Test
	public void testgetUserById(){
		Address demoaddress = new  Address("A-199","mg road","jaipur","rajasthan",Integer.valueOf("241412"));
		ArrayList<String> demochannel = new ArrayList<>();
		demochannel.add("SMS");
		User demouser = new User("shivani","sha@gmail.com",
				7643456789L,demoaddress,
				3123214219989L,demochannel
				);
		when(userRepository.findByUsername("shivani")).thenReturn(demouser);
		User result = userService.getUserByUsername("shivani");
		assertEquals("shivani", result.getUsername());
		assertEquals("sha@gmail.com", result.getEmail());
	}
	
	@Test
	public void testcreateUser(){
		Address demoaddress = new  Address("A-199","mg road","jaipur","rajasthan",Integer.valueOf("241412"));
		ArrayList<String> demochannel = new ArrayList<>();
		demochannel.add("SMS");
		User demouser = new User("shivi","sha@gmail.com",
				7643456789L,demoaddress,
				3123214219989L,demochannel
				);
		when(userRepository.save(demouser)).thenReturn(demouser);
		User result = userService.createUser(demouser);
		assertEquals("shivi", result.getUsername());
		assertEquals("sha@gmail.com", result.getEmail());
	
	}

}
