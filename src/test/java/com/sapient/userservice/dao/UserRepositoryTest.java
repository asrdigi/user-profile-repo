package com.sapient.userservice.dao;

import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.sapient.userservice.UserserviceApplication;
import com.sapient.userservice.dao.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserserviceApplication.class)
public class UserRepositoryTest {
		
	@Autowired
    private UserRepository userRepository;
    
    @Test
    public void testSaveAndFindUser() throws Exception {    	
        assertNull(userRepository.findByUsername("wrong"));
    }

}
