package com.hongshao.jdbc;

public class User {

	public String loginName;
	public String userName;
	public String password;
	public int sex;

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public User(String loginName, String userName, String password, int sex) {
		super();
		this.loginName = loginName;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
