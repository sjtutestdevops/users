package com.devops.users;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Service
public class UserService {


    public String create() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //一开始必须填一个已经存在的数据库
            String url = "jdbc:mysql://localhost:3306/default?useUnicode=true&characterEncoding=utf-8";
            Connection conn = DriverManager.getConnection(url, "admin", "123456");
            Statement stat = conn.createStatement();
            stat.executeUpdate("create database hello");
            return "Success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
