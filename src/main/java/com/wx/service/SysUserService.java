package com.wx.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wx.model.SysAuthority;
import com.wx.model.SysRole;
import com.wx.model.SysUser;

@Service
public interface SysUserService {
	//根据用户名查询出一条用户信息
	SysUser findUser(String username);
	//根据id查询出一条用户信息
	SysUser findUserById(int id);
	//根据用户id查询出用户的角色
	List<SysRole> findRole(int userid);
	//根据角色编号查询出角色对应的权限
	List<SysAuthority> findPremission(String role_key);
	//添加一个用户
	void addUser(SysUser user);
	//员工离职方法
	void deleteUser(int userId);
	//修改员工信息方法
	void updateUser(SysUser user);

}
