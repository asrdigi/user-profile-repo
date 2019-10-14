package com.sapient.userservice;

 

import javax.annotation.PostConstruct;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

 

import com.sapient.userservice.service.UserService;

 

@Component
public class PingMongo {
    
    @Autowired 
    private UserService service;

    @PostConstruct
    public void init(){
        service.getUserByUsername("started");
        service.getUserByUsername("started");
    }
}