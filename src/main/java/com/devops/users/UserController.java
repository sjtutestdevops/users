package com.devops.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Object test(){
        return "success";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public Object create() {
        return userService.create();
    }

}
