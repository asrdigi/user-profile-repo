package com.sapient.userservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sapient.userservice.dao.MessageTemplate;

@FeignClient(name="userprofile-producer")
public interface KafkaProducerProxy {
  @PostMapping(value = "/kafka/publish",  consumes= {"application/json"})
  	public void sendMessage(@RequestBody MessageTemplate payload);
}