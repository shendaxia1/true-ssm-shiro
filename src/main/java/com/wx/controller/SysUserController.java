package com.wx.controller;

import java.io.IOException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wx.model.SysUser;
import com.wx.model.SysUserRole;
import com.wx.service.SysRoleService;
import com.wx.service.SysUserRoleService;
import com.wx.service.SysUserService;
import com.wx.util.SaltMD5;




@Controller
@RequestMapping("/user")
public class SysUserController extends BaseController{
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysUserRoleService sysUserRoleService;

	/**
	 * �û���½������
	 * @param username�û���
	 * @param password����
	 * @throws IOException
	 */
	@RequestMapping("/login")
	@ResponseBody 
	public void checkLogin(String username, String password) throws IOException {
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isAuthenticated()) {
			try {
			//ʹ��shiro��������֤
			currentUser.login(token);
			}
			/* result.put("sucess", true); */
			catch (AuthenticationException e) {
				result.setSuccess(false);
				result.setMessage("��¼ʧ��");
				super.writeJSON(result);
				return;
				}
		} 
		String name = (String)SecurityUtils.getSubject().getPrincipal();//ȥ�õ�SimpleAuthenticationInfo�ĵ�һ��������������������û���
		SysUser user = sysUserService.findUser(name);
		if(user.getFlat()==0) {
			result.setSuccess(false);
			result.setMessage("Ա������ְ");
			super.writeJSON(result);
			return;
		}
		result.setSuccess(true);
		result.setMessage("��¼�ɹ�");
		super.writeJSON(result);
		return;
		
	}
	/**
	 * ����û����Ʋ㷽��
	 * @param user����һ���û�����
	 * @throws IOException 
	 */
	@RequestMapping("/addUser")
	public void addUser(SysUser user,String role) throws IOException {
		if(user.getUsername()!=null&&user.getPassword()!=null) {//�ж�ǰ̨������û��������Ƿ�Ϊ��
		user.setFlat(1);
		String salt = Double.toString(Math.random());//�Լ�������ֵ
		user.setSalt(salt);
		String password = SaltMD5.md5(user.getPassword(), salt);//���ܺ�����뱣�浽���ݿ�
		user.setPassword(password);
		sysUserService.addUser(user);
		}else {
			result.setMessage("�û��������벻��Ϊ��");
			return;
		}
		int userId = sysUserService.findUser(user.getUsername()).getUserid();
		String[] gg = role.split(",");
		if(role.length()!=0) {
		SysUserRole ur = new SysUserRole();
		for(String role_value:gg) {
			String role_key = sysRoleService.findRoleKey(role_value);
			ur.setUser_id(userId);
			ur.setRole_key(role_key);
			sysUserRoleService.addUserRole(ur);
		}
		}else {
			result.setMessage("������û���ɫ");
			super.writeJSON(result);
			return;
		}
		result.setSuccess(true);
		result.setMessage("����û��ɹ�");
		super.writeJSON(result);
		return;
	}
	/**
	 * Ա����ְ�������Ʋ㷽��
	 * @param userId�����û�id
	 * @throws IOException 
	 */
	
	  @RequestMapping("/deleteUser") 
	  public void deleteUser(int userId) throws IOException {
	  
		  sysUserService.deleteUser(userId);
		  result.setSuccess(true);
		  result.setMessage("ɾ���ɹ�");
		  super.writeJSON(result);
		  return;
	  }
	  /**
	   * �޸�Ա����Ϣ���Ʋ㷽��
	   * @param user
	   * @throws IOException
	   */
	  
	  @RequestMapping("/updateUser")
	  public void updateUser(SysUser user) throws IOException {
		  sysUserService.updateUser(user);
		  result.setSuccess(true);
		  result.setMessage("�޸�Ա����Ϣ�ɹ�");
		  super.writeJSON(result);
		  return;
	  }
	  
	  @RequestMapping("/updateUserRole")
	  public void updateUserRole(SysUserRole ur) {
		  sysUserRoleService.deleteUR(ur.getUser_id());
		  String[] role_key = ur.getRole_key().split(",");
		  int userId = ur.getUser_id();
		  SysUserRole ur1 = new SysUserRole();
		  for(String role:role_key) {
			  ur1.setUser_id(userId);
			  ur1.setRole_key(role);
			  sysUserRoleService.addUserRole(ur1);
		  }
		  result.setSuccess(true);
		  result.setMessage("��ӳɹ�");
		  return;
		  
	  }
}
