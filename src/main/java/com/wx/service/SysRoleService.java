package com.wx.service;

import org.springframework.stereotype.Service;

@Service
public interface SysRoleService {
	
	String findRoleKey(String role_value);

}
