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
     * ���DB������Ķ���,���ֻ�ȡ����ķ�ʽ������jdk�Ƽ�ʹ�á�
     */
    public static  singletonConnection getInstance(){
        return DBUtilClassInstance.dbUtil;
    }

    /**
     * �����ڲ��൥��ģʽ����Ȼ�̰߳�ȫ���ӳټ��أ�����Ч�ʸߡ������˽⣬�ο��ҵ��������ģʽ-����ģʽ
     */
    private static class DBUtilClassInstance{
        private  static  singletonConnection dbUtil= new singletonConnection();
    }

    /**
     * ��ȡJDBC����
     * @return
     */
    public  Connection getConnection(){
        try {
            if(null!=connection && !connection.isClosed()){
                return connection;
            }
            Class.forName(DRIVER);
            System.out.println("����������سɹ���");
            connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            return connection;
        } catch (Exception e) {
            System.out.println("δ�ҵ���������");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * ͨ����ȡ�ļ�����
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
                System.out.println("�Ҳ����ļ�:"+fileName);
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
