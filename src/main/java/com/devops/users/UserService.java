package com.devops.users;

import com.devops.users.mapper.UserMapper;
import com.devops.users.model.User;
import com.devops.users.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://10.0.2.174:3306/devops?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT";
            Connection conn = DriverManager.getConnection(url, "root", "ym19950823");
            Statement stat = conn.createStatement();
            
    		String sql = "select * from user where username = '" + name + "'";
    		System.out.println(sql);
            ResultSet result = stat.executeQuery(sql);
            result.beforeFirst();
            result.last();
            System.out.println(result.getRow());
            if (result.getRow() > 0) {
            	return "用户名已存在";
            }
            sql = "insert into user (username, pwd) value ('"+name+"', '"+pwd+"')";
            System.out.println(sql);
            stat.executeUpdate(sql);
            return "Success";
        } catch (Exception e) {
            return e.getMessage();
        }
	}
    
    public String signIn(String name, String pwd) {
		try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://10.0.2.174:3306/devops?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT";
            Connection conn = DriverManager.getConnection(url, "root", "ym19950823");
            Statement stat = conn.createStatement();
            
    		String sql = "select * from user where username = '" + name + "' and pwd = '" + pwd + "'";
    		System.out.println(sql);
            ResultSet result = stat.executeQuery(sql);
            result.beforeFirst();
            result.last();
            System.out.println(result.getRow());
            if (result.getRow() > 0) {
            	return "success";
            }
            return "fail";
        } catch (Exception e) {
            return e.getMessage();
        }
	}
    
    public String getUserId(String name) {
		try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://10.0.2.174:3306/devops?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT";
            Connection conn = DriverManager.getConnection(url, "root", "ym19950823");
            Statement stat = conn.createStatement();
            
    		String sql = "select user_id from user where username = '" + name + "'";
    		System.out.println(sql);
            ResultSet result = stat.executeQuery(sql);
            if(result.next()) {
            	return result.getString("user_id");
            }
            return "fail";
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            return "error";
        }
	}


}
