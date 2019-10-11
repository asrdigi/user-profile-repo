package com.sapient.userservice.model;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "user")
public class User {
	
	@Id
	private ObjectId _id;
	
	private String username;
	
	private String email;
	private Long phoneNumber;
	private Address address;
	private Long fundTransactionLimit;
	private ArrayList<String> channelPreference;
	
    public User() {
    	
    }

	

	public User(String username, String email, Long phoneNumber, Address address, Long fundTransactionLimit,
			ArrayList<String> channelPreference) {
		super();
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.fundTransactionLimit = fundTransactionLimit;
		this.channelPreference = channelPreference;
	}

	
	public ObjectId get_id() {
		return _id;
	}



	public void set_id(ObjectId _id) {
		this._id = _id;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getFundTransactionLimit() {
		return fundTransactionLimit;
	}

	public void setFundTransactionLimit(Long fundTransactionLimit) {
		this.fundTransactionLimit = fundTransactionLimit;
	}

	public ArrayList<String> getChannelPreference() {
		return channelPreference;
	}

	public void setChannelPreference(ArrayList<String> channelPreference) {
		this.channelPreference = channelPreference;
	}




















	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address="
				+ address + ", fundTransactionLimit=" + fundTransactionLimit + ", channelPreference="
				+ channelPreference + "]";
	}













	
}






	
	
    
    
    


