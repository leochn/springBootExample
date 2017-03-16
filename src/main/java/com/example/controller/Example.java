package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.User;
import com.example.service.UserService;

// 直接支持RESTFul
@RestController  
public class Example {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/hello")  
    public String home() {  
        return "Hello World!";  
    }  
      
    @RequestMapping("/hello/{myName}")  
    public String index(@PathVariable String myName) {  
        return "Hello "+myName+"!";  
    }  
    
    @RequestMapping("/user/{id}")  
    public User userById(@PathVariable String id){
    	User user = this.userService.getById(id);
    	return user;
    }

}
