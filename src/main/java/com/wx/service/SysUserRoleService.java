package com.wx.service;

import org.springframework.stereotype.Service;

import com.wx.model.SysUserRole;
@Service
public interface SysUserRoleService {
	
	void addUserRole(SysUserRole sysUserRole);//添加用户角色
	
	void deleteUR(int userId);//根据用户id删除该用户对应的所有角色
	
	

}
