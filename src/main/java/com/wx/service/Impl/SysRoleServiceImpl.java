package com.wx.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.mapper.SysRoleMapper;
import com.wx.service.SysRoleService;
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Override
	public String findRoleKey(String role_value) {
		// TODO Auto-generated method stub
		return sysRoleMapper.findRoleKey(role_value);
	}
	
	

}
