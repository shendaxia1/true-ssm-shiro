package com.wx.mapper;

import org.springframework.stereotype.Repository;

@Repository("SysRoleMapper")
public interface SysRoleMapper {
	
	String findRoleKey(String role_value);

}
