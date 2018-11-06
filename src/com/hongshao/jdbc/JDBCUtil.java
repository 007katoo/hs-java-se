package com.hongshao.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    //Driver��ȫ��
    public static String DRIVER="com.mysql.jdbc.Driver";
    //jdbcЭ��:��Э��://ip:�˿ں�/���ݿ���
    public static String URL="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=FALSE";
    //���ݿ��û���
    public static String USERNAME="root";
    //���ݿ�����
    public static String PASSWORD="root";

    private static Connection connection=null;

    /**
     * ��ȡJDBC����
     * @return
     */
    public  static Connection getConnection(){
        try {
            //��������������ͨ�����䴴��һ��driver����
            Class.forName(DRIVER);

            //����������Ӷ���
            // �ڷ���connection����֮ǰ��DriverManager���ڲ�����У����������driver��Ϣ�Բ���,����ֻҪ֪���ڲ����̼��ɡ�
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            return connection;
        } catch (Exception e) {
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
        /*
            �ļ���������ݣ�������ĳ���һģһ��
            jdbc.driver=com.mysql.jdbc.Driver
            jdbc.url=jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8
            jdbc.username=root
            jdbc.password=root
        */
        Properties props=new Properties();
        try {
            //�ҵ�properties�ļ��Ƿ���src��Ŀ¼�µ�
            InputStream in=JDBCUtil.class.getResourceAsStream("/"+fileName);
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
}
