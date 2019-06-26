package com.devops.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Object test(){
        return "success";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Object create() {
        return userService.get();
    }
    
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public Object signUp(@RequestParam(value = "name", required = true) String name,
    		@RequestParam(value = "pwd", required = true) String pwd){
    	String status = userService.signUp(name, pwd);
    	return status;
    }
  
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public Object signIn(@RequestParam(value = "name", required = true) String name,
    		@RequestParam(value = "pwd", required = true) String pwd){
    	String status = userService.signIn(name, pwd);
    	return status;
    } 
    
}
