package com.devops.users;

import com.devops.users.mapper.UserMapper;
import com.devops.users.model.User;
import com.devops.users.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public String get() {

        try {
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUserIdEqualTo(1);
            List<User> userList = userMapper.selectByExample(userExample);
            return userList.get(0).getUsername();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String signUp(String name, String pwd) {
		try {
			UserExample userExample = new UserExample();
			userExample.createCriteria().andUsernameEqualTo(name);
			List<User> userList = userMapper.selectByExample(userExample);
			if (userList.size() > 0) {
				return "用户名已存在";
			}
			
			User user = new User();
			user.setUsername(name);
			user.setPwd(pwd);
			userMapper.insert(user);
			return "Success";
        } catch (Exception e) {
            return e.getMessage();
        }
	}
    
    public String signIn(String name, String pwd) {
		try {
			UserExample userExample = new UserExample();
			userExample.createCriteria().andUsernameEqualTo(name).andPwdEqualTo(pwd);
			List<User> userList = userMapper.selectByExample(userExample);
			if (userList.size() == 0) {
				return "fail";
			}
			return "Success";
        } catch (Exception e) {
            return e.getMessage();
        }
	}
    
    public Integer getUserId(String name) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(name);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size() > 0) {
            return userList.get(0).getUserId();
        }
        return 0;
	}


}
