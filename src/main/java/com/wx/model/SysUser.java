package com.wx.model;

public class SysUser {
	private int userid;//用户id
	private String username;//用户名
	private String password;//密码
	private String department_key;//所属部门
	private String salt;//密码盐值
	private int flat;//是否离职0是 1否
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment_key() {
		return department_key;
	}
	public void setDepartment_key(String department_key) {
		this.department_key = department_key;
	}

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getFlat() {
		return flat;
	}
	public void setFlat(int flat) {
		this.flat = flat;
	}




	
	

}
