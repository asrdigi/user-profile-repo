package com.sapient.userservice.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.userservice.dao.MessageTemplate;
import com.sapient.userservice.model.User;
import com.sapient.userservice.service.UserService;


@FeignClient(name="userprofile-producer")
interface KafkaProducerProxy {
  @PostMapping(value = "/kafka/publish",  consumes= {"application/json"})
  	public void sendMessage(@RequestBody MessageTemplate payload);
}


@RestController
public class UserController {
	
	@Autowired
	private KafkaProducerProxy proxy;
	
	@Autowired
	Environment environment;

	@Autowired
	UserService userService;

	@GetMapping("/backend")
	public String backend() {
		System.out.println("Inside MyRestController::backend...");

		String serverPort = environment.getProperty("local.server.port");

		System.out.println("Port : " + serverPort);

		return "Hello form Backend!!! " + " Host : localhost " + " :: Port : " + serverPort;
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUsersByUsername(@PathVariable("id") String id) {
		return new ResponseEntity<User>(userService.getUserByUsername(id), HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.OK);
	}

	@PutMapping("/users")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
		String oldEmail = userService.getUserByUsername(user.getUsername()).getEmail() ;
		
		System.out.println("user-----" + user);
		
		//call the producer with new email updated with users details
		if(!user.getEmail().equals(oldEmail)) {
			MessageTemplate payload = new MessageTemplate("Dear " + user.getUsername() +
					", your email has changed successfully to " + user.getEmail(), user.getChannelPreference().get(0), user.getPhoneNumber().toString(), user.getEmail());
			//call producer of kafka
			proxy.sendMessage(payload);
		}
		return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.OK);
		
	}

}
