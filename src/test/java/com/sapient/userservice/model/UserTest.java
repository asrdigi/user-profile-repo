package com.sapient.userservice.model;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class UserTest {
	
	@Test
	public void testUsername() {
        User user = new User();
        user.setUsername("test");
        assertTrue(user.getUsername() == "test");
    }
	
	@Test
	public void testEmail() {
        User user = new User();
        user.setEmail("test");
        assertTrue(user.getEmail() == "test");
    }
	
	@Test
	public void testPhoneNumber() {
        User user = new User();
        user.setPhoneNumber(12345L);
        assertTrue(user.getPhoneNumber() == 12345L);
    }
	
	@Test
	public void testAddress() {
        User user = new User();
        Address address = new Address("line1","line2","state","city",273014);
        user.setAddress(address);
        assertEquals(user.getAddress().toString() , new Address("line1","line2","state","city",273014).toString());
    }
	
	@Test
	public void testFundTransactionLimit() {
        User user = new User();
        user.setFundTransactionLimit(12345L);
        assertTrue(user.getFundTransactionLimit() == 12345L);
    }
	
	@Test
	public void testChannelPreference() {
        User user = new User();
        ArrayList<String> al = new ArrayList<String>();
        al.add("sms");
        user.setChannelPreference(al);
        assertTrue(user.getChannelPreference() == al);
    }
	
	
	
	
	
	
	
	
	
 

}
