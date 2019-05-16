package com.wx.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wx.model.SysAuthority;
import com.wx.model.SysRole;
import com.wx.model.SysUser;
@Repository("SysUserMapper")
public interface SysUserMapper {
	//根据用户名查询出一条用户信息dao
	SysUser findUser(String username);
	//根据用户id查询出一个用户信息
	SysUser findUserById(int id);
	//根据用户id查询出用户的角色
	List<SysRole> findRole(int userid);
	//根据查询出的rolekey查询出该角色的权限
	List<SysAuthority> findPermissions(String role_key);
	//添加用户方法
	void addUser(SysUser user);
	//员工离职方法
	void deleteUser(int userId);
	//修改员工信息方法
	void updateUser(SysUser user);

}
