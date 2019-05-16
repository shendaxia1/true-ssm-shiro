package com.wx.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wx.model.SysAuthority;
import com.wx.model.SysRole;
import com.wx.model.SysUser;
@Repository("SysUserMapper")
public interface SysUserMapper {
	//�����û�����ѯ��һ���û���Ϣdao
	SysUser findUser(String username);
	//�����û�id��ѯ��һ���û���Ϣ
	SysUser findUserById(int id);
	//�����û�id��ѯ���û��Ľ�ɫ
	List<SysRole> findRole(int userid);
	//���ݲ�ѯ����rolekey��ѯ���ý�ɫ��Ȩ��
	List<SysAuthority> findPermissions(String role_key);
	//����û�����
	void addUser(SysUser user);
	//Ա����ְ����
	void deleteUser(int userId);
	//�޸�Ա����Ϣ����
	void updateUser(SysUser user);

}
