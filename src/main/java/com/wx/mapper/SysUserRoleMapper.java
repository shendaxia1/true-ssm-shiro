package com.wx.mapper;

import org.springframework.stereotype.Repository;

import com.wx.model.SysUserRole;
@Repository("SysUserRoleMapper")
public interface SysUserRoleMapper {
	
	void addUserRole(SysUserRole sysUR);//���û���ӽ�ɫ
	
	void deleteUR(int userId);//ɾ��һ���û������н�ɫ

}
