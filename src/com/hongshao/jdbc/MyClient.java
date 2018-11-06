package com.hongshao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

public class MyClient {

	@Test
	public void stateMentTest() {
		Connection connection = null;
		Statement statement = null;

		try {
			connection = JDBCUtil.getConnection();
			statement = connection.createStatement();
			String sql = "insert into user(loginName,userName,password,sex)values('tom123','tom','123456',1)";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void prepareStateMentTest() {
		Connection connection = null;
		PreparedStatement pStatement = null;

		connection = JDBCUtil.getConnection();
		String sql = "insert into user(loginName,userName,password,sex)values(?,?,?,?)";
		// Ԥ����
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, "tom123");
			pStatement.setString(2, "tom");
			pStatement.setString(3, "123456");
			pStatement.setInt(4, 1);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ǰ���������Ӧ������ʺ�,���ݲ�����
	}

	@Test
	public void resultSetTest() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet;

		connection = JDBCUtil.getConnection();
		String sql = "select * from user";
		try {
			statement = connection.createStatement();
			// resultSet����һ��������,����ķ���������������һ�¡�
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String loginName = resultSet.getString("loginName");
				String userName = resultSet.getString("userName");
				String password = resultSet.getString("password");
				int sex = resultSet.getInt("sex");
				System.out.println(loginName + "-" + userName + "-" + password + "-" + sex);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void scrollAndUpdate() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtil.getConnection();
			// ��һ�����������Ƿ���Թ������ڶ������������Ƿ�ɸ���
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from user";
			ResultSet rs = statement.executeQuery(sql);

			/**
			 * �ɹ����ļ������� rs.previous(); rs.next(); rs.getRow(); rs.absolute(0);
			 **/

			// �����ݼ������������ͬʱ���µ����ݣ��ӱ�����ʼ���롣
			rs.moveToInsertRow();// ���α��ƶ��������У�Ĭ�������һ�С�
			rs.updateString("loginName", "С����");
			rs.updateString("userName", "������");
			rs.updateString("password", "123");
			rs.updateInt("sex", 100);
			rs.insertRow();
			rs.moveToCurrentRow();// ���α��ƶ����һ��λ��

			// ɾ����ʮ������
//            rs.absolute(10);
//            rs.deleteRow();
//
//            while(rs.next()){
//                System.out.println(rs.getString(2));
//                //�����ݼ���������е��Ա�ȫ������Ϊ0
//                rs.updateInt("sex",0);
//                rs.updateRow();
//            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void batchUpdate() {
		long time = System.currentTimeMillis();
		Connection connection = null;
		PreparedStatement pStatement = null;
		boolean autoCommit = false;
		Savepoint savepoint = null;
		try {
			connection = JDBCUtil.getConnection();
			autoCommit = connection.getAutoCommit();
			connection.setAutoCommit(false);
			String sql = "insert into user(loginName,userName,password,sex)values(?,?,?,?)";
			pStatement = connection.prepareStatement(sql);
			// ���ñ����
			savepoint = connection.setSavepoint("savePoint");
			for (int i = 0; i < 1000; i++) {
				pStatement.setString(1, "tony" + i);
				pStatement.setString(2, "user" + i);
				pStatement.setString(3, i + "");
				pStatement.setInt(4, i);
				// ��ӵ�����
				pStatement.addBatch();
			}
			// ����ִ��
			pStatement.executeBatch();
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			// �ع��������
			try {
				connection.rollback(savepoint);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			// �������ύ����Ϊ�������
			try {
				connection.setAutoCommit(autoCommit);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long temp = System.currentTimeMillis() - time;
		System.out.println(temp + "ms");
	}
	
	@Test
	public void testPerformance() {
		long time = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			User user = new User("loginName" + i, "userName" + i, "password" + i, i);
			Mythread thread = new Mythread(user);
			thread.run();
		}
		System.out.println(System.currentTimeMillis() - time + "ms");
	}
}
