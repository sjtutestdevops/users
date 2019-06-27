package com.devops.users;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
public class UserService {


    public String get() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //一开始必须填一个已经存在的数据库
            String url = "jdbc:mysql://10.0.0.82:3306/product?useUnicode=true&characterEncoding=utf-8";
            Connection conn = DriverManager.getConnection(url, "root", "123456");
            Statement stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery("select * from user");
            if (resultSet.next()) {
                return resultSet.getString("username");
            }
            return "0";
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
