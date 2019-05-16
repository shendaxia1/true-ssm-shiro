package com.wx.model;

import java.math.BigInteger;

public class SysDepartment {
	private BigInteger id;//自增主键
	private String department_key;//部门编号
	private String department_value;//部门名称
	private String description;//描述
	private String parent_departmentkey;//上级部门编码
	private String create_time;//创建时间
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getDepartment_key() {
		return department_key;
	}
	public void setDepartment_key(String department_key) {
		this.department_key = department_key;
	}
	public String getDepartment_value() {
		return department_value;
	}
	public void setDepartment_value(String department_value) {
		this.department_value = department_value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParent_departmentkey() {
		return parent_departmentkey;
	}
	public void setParent_departmentkey(String parent_departmentkey) {
		this.parent_departmentkey = parent_departmentkey;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	

}
