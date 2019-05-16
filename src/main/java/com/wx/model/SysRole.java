package com.wx.model;

import java.math.BigInteger;

public class SysRole {
	private int role_id;
	private String role_key;
	private String create_time;
	private String description;
	private String role_value;
	private BigInteger company_id;
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_key() {
		return role_key;
	}
	public void setRole_key(String role_key) {
		this.role_key = role_key;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRole_value() {
		return role_value;
	}
	public void setRole_value(String role_value) {
		this.role_value = role_value;
	}
	public BigInteger getCompany_id() {
		return company_id;
	}
	public void setCompany_id(BigInteger company_id) {
		this.company_id = company_id;
	}
	

}
