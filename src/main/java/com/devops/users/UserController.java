package com.devops.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @RequestMapping(path = "test", method = RequestMethod.GET)
    public Object test(){
        return "success";
    }

}
