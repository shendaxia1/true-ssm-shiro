package com.wx.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wx.model.SysAuthority;
import com.wx.model.SysRole;
import com.wx.model.SysUser;

@Service
public interface SysUserService {
	//�����û�����ѯ��һ���û���Ϣ
	SysUser findUser(String username);
	//����id��ѯ��һ���û���Ϣ
	SysUser findUserById(int id);
	//�����û�id��ѯ���û��Ľ�ɫ
	List<SysRole> findRole(int userid);
	//���ݽ�ɫ��Ų�ѯ����ɫ��Ӧ��Ȩ��
	List<SysAuthority> findPremission(String role_key);
	//���һ���û�
	void addUser(SysUser user);
	//Ա����ְ����
	void deleteUser(int userId);
	//�޸�Ա����Ϣ����
	void updateUser(SysUser user);

}
