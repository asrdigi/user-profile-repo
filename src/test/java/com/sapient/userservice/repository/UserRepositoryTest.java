package com.sapient.userservice.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.jar.Attributes.Name;

import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.annotation.ProfileValueSourceConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.sapient.userservice.UserserviceApplication;
import com.sapient.userservice.dao.UserRepository;
import com.sapient.userservice.model.Address;
import com.sapient.userservice.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserserviceApplication.class)
public class UserRepositoryTest {
	
	
	
	
	@Autowired
    private UserRepository userRepository;
    
  
    @Test
    public void testSaveAndFindUser() throws Exception {
//    	Address demoaddress = new  Address("A-199","mg road","jaipur","rajasthan",Integer.valueOf("241412"));
//		ArrayList<String> demochannel = new ArrayList<>();
//		demochannel.add("SMS");
//		User demouser = new User("rishabh","sha@gmail.com",
//				7643456789L,demoaddress,
//				3123214219989L,demochannel
//				);
//        userRepository.save(demouser);
//       
//        assertEquals(demouser.toString(), userRepository.findByUsername("rishabh").toString());
        assertNull(userRepository.findByUsername("wrong"));
    }

}
