package com.sapient.userservice.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.sapient.userservice.dao.UserRepository;
import com.sapient.userservice.model.Address;
import com.sapient.userservice.model.User;
import com.sapient.userservice.service.UserServiceImpl;

@RunWith(SpringRunner.class)
/*
 * @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
 */
//@WebAppConfiguration
//@ContextConfiguration(classes = UserserviceApplication.class)
@AutoConfigureMockMvc
//@WebMvcTest(UserController.class)
@SpringBootTest("UserController.class")
public class UserControllerTest {

	// @Autowired
	private MockMvc mvc;
	@MockBean
	private UserServiceImpl service;
	@MockBean
	private UserRepository repo;

	@Autowired
	WebApplicationContext wac;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
	}

	@Test
	public void should_post_when_validUser() throws Exception {
		Address demoaddress = new Address("A-199", "civil lines", "jaipur", "rajasthan", Integer.valueOf("241412"));
		ArrayList<String> demochannel = new ArrayList<>();
		demochannel.add("SMS");
		User demouser = new User("demo", "yaa@gmail.com", 7643456789L, demoaddress, 3123214219989L, demochannel);

		Gson gson = new Gson();
		String json = gson.toJson(demouser);
		given(service.createUser(Mockito.any())).willReturn(demouser);
		mvc.perform(
				post("/users").contentType(MediaType.APPLICATION_JSON).content(json).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(jsonPath("$.address.state").value("rajasthan"))
		.andExpect(jsonPath("$.username").value("demo"));
	}


	@Test public void update_when_validUser() throws Exception {
				
		Address demoaddress = new Address("A-199", "civil lines", "jaipur", "rajasthan", Integer.valueOf("241412"));
		ArrayList<String> demochannel = new ArrayList<>();
		demochannel.add("SMS");
		User demouser = new User("demo", "yaa@gmail.com", 7643456789L, demoaddress, 3123214219989L, demochannel);

		Gson gson = new Gson();
		String json = gson.toJson(demouser);
		given(service.createUser(Mockito.any())).willReturn(demouser);
		mvc.perform(
				post("/users").contentType(MediaType.APPLICATION_JSON).content(json).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(jsonPath("$.address.state").value("rajasthan"))
		.andExpect(jsonPath("$.username").value("demo"));


	}


	@Test
	public void get_user_when_validUser_isEntered() throws Exception {

		Address demoaddress = new Address("A-199", "civil lines", "jaipur", "rajasthan", Integer.valueOf("241412"));
		ArrayList<String> demochannel = new ArrayList<>();
		demochannel.add("SMS");
		User demouser = new User("demo", "yaa@gmail.com", 7643456789L, demoaddress, 3123214219989L, demochannel);

		Gson gson = new Gson();
		String json = gson.toJson(demouser);
		given(service.getUserByUsername(Mockito.any())).willReturn(demouser);

		mvc.perform(get("/users/demo").contentType(MediaType.APPLICATION_JSON).content(json)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$.address.state").value("rajasthan"))
		.andExpect(jsonPath("$.username").value("demo"));

	}
}
