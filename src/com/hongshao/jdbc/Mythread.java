package com.hongshao.jdbc;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Mythread {
	
	private User user;

    public Mythread(User user){
        this.user=user;
    }

    public void run() {
        PreparedStatement pStatement=null;
        Connection connection=null;
        try {
            connection=singletonConnection.getInstance().getConnectionByLoadSettingFile("db.properties");
            String sql="insert into user(loginName,userName,password,sex)value(?,?,?,?)";
            pStatement=connection.prepareStatement(sql);
            pStatement.setString(1,user.getLoginName());
            pStatement.setString(2,user.getUserName());
            pStatement.setString(3,user.getPassword());
            pStatement.setInt(4,user.getSex());
            pStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //注释掉这个方法就是代表数据库连接用完就随即关闭。
//        	singletonConnection.getInstance().closePreparedStatement(pStatement);
//        	singletonConnection.getInstance().closeConnection(connection);
        }
    }
}
