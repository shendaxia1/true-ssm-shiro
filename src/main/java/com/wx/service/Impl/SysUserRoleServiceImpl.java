package com.wx.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.mapper.SysUserRoleMapper;
import com.wx.model.SysUserRole;
import com.wx.service.SysUserRoleService;
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;

	@Override
	public void addUserRole(SysUserRole sysUserRole) {
		// TODO Auto-generated method stub
		sysUserRoleMapper.addUserRole(sysUserRole);
		
	}

	@Override
	public void deleteUR(int userId) {
		// TODO Auto-generated method stub
		sysUserRoleMapper.deleteUR(userId);
	}

}
