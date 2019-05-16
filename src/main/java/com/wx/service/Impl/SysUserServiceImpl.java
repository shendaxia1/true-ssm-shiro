package com.wx.service.Impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.mapper.SysUserMapper;
import com.wx.model.SysAuthority;
import com.wx.model.SysRole;
import com.wx.model.SysUser;
import com.wx.service.SysUserService;
@Service("SysUserService")
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser findUser(String username) {
		// TODO Auto-generated method stub
		return sysUserMapper.findUser(username);
	}

	@Override
	public SysUser findUserById(int id) {
		// TODO Auto-generated method stub
		return sysUserMapper.findUserById(id);
	}

	@Override
	public List<SysRole> findRole(int userid) {
		// TODO Auto-generated method stub
		return sysUserMapper.findRole(userid);
	}

	@Override
	public List<SysAuthority> findPremission(String role_key) {
		// TODO Auto-generated method stub
		return sysUserMapper.findPermissions(role_key);
	}

	@Override
	public void addUser(SysUser user) {
		// TODO Auto-generated method stub
		sysUserMapper.addUser(user);
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		sysUserMapper.deleteUser(userId);
	}

	@Override
	public void updateUser(SysUser user) {
		// TODO Auto-generated method stub
		sysUserMapper.updateUser(user);
	}

}
