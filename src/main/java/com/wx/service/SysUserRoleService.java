package com.wx.service;

import org.springframework.stereotype.Service;

import com.wx.model.SysUserRole;
@Service
public interface SysUserRoleService {
	
	void addUserRole(SysUserRole sysUserRole);//����û���ɫ
	
	void deleteUR(int userId);//�����û�idɾ�����û���Ӧ�����н�ɫ
	
	

}
