package com.hongshao.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class singletonConnection {
    public static String DRIVER="com.mysql.jdbc.Driver";
    public static String URL="jdbc:mysql://localhost:3306/test";
    public static String USERNAME="root";
    public static String PASSWORD="root";

    private  Connection connection=null;
    private singletonConnection(){
    }
    /**
     * 获得DB工具类的对象,这种获取对象的方式慢慢被jdk推荐使用。
     */
    public static  singletonConnection getInstance(){
        return DBUtilClassInstance.dbUtil;
    }

    /**
     * 采用内部类单例模式：天然线程安全，延迟加载，调用效率高。若不了解，参考我的文章设计模式-单例模式
     */
    private static class DBUtilClassInstance{
        private  static  singletonConnection dbUtil= new singletonConnection();
    }

    /**
     * 获取JDBC连接
     * @return
     */
    public  Connection getConnection(){
        try {
            if(null!=connection && !connection.isClosed()){
                return connection;
            }
            Class.forName(DRIVER);
            System.out.println("驱动程序加载成功！");
            connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            return connection;
        } catch (Exception e) {
            System.out.println("未找到驱动程序！");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过读取文件连接
     * @param fileName
     * @return
     * @throws SQLException
     */
    public   Connection getConnectionByLoadSettingFile(String fileName) throws SQLException {
        if(null!=connection && !connection.isClosed()){
            return connection;
        }
        Properties props=new Properties();
        try {
            InputStream in=singletonConnection.class.getResourceAsStream("/"+fileName);
            if(null==in)
                System.out.println("找不到文件:"+fileName);
            props.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String driver=props.getProperty("jdbc.driver");
        if(null!=driver)
            System.setProperty("jdbc.drivers",driver);
        String url=props.getProperty("jdbc.url");
        String username=props.getProperty("jdbc.username");
        String password=props.getProperty("jdbc.password");
        connection=DriverManager.getConnection(url,username,password);
        return connection;
    }
    
    public void closePreparedStatement(PreparedStatement preparedStatement) {
    	try {
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void closeConnection(Connection connection) {
    	try {
    		connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
