package com.wx.model;

import java.math.BigInteger;

public class SysDepartment {
	private BigInteger id;//��������
	private String department_key;//���ű��
	private String department_value;//��������
	private String description;//����
	private String parent_departmentkey;//�ϼ����ű���
	private String create_time;//����ʱ��
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
