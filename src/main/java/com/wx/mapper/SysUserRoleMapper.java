package com.wx.mapper;

import org.springframework.stereotype.Repository;

import com.wx.model.SysUserRole;
@Repository("SysUserRoleMapper")
public interface SysUserRoleMapper {
	
	void addUserRole(SysUserRole sysUR);//给用户添加角色
	
	void deleteUR(int userId);//删除一个用户的所有角色

}
