package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Tbuser;
import com.example.pojo.User;
import com.example.service.ApiService;
import com.example.service.TbuserService;
import com.example.service.UserService;
import com.example.util.JsonResult;

// 直接支持RESTFul
@RestController  
public class Example {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TbuserService tbuserService;
	
	@Autowired
	private ApiService apiService;
	
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
    
    @RequestMapping("/tbuser")  
    public List<Tbuser> queryAll(){
    	List<Tbuser> list = this.tbuserService.queryAll();
    	return list;
    }
    
    //@ResponseBody
	@RequestMapping(value = "/alarms")
	public ResponseEntity<JsonResult> getAlarmData(@RequestParam(required = false) String alarmTypeId ) {
		try {
			JsonResult result = this.apiService.getAlarms(null);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			//.....
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

}
