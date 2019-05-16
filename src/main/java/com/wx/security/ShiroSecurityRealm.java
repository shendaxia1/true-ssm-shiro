package com.wx.security;





import java.security.Principal;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


import com.wx.mapper.SysUserMapper;
import com.wx.model.SysAuthority;
import com.wx.model.SysRole;
import com.wx.model.SysUser;
import com.wx.service.SysUserService;


public class ShiroSecurityRealm extends AuthorizingRealm {
	@Autowired
	private SysUserService sysUserService;
	/*
	 * @Autowired private SysUserMapper sysUserMapper;
	 *///ע������ֻ��ע��ӿڣ���Ϊshiro���Ǳ�springmvc�ȼ��ص��������ֱ��ע����Ļ��ͻ����Ҳ��������Ĵ�����Ϊִ�е����ʱ��û��bean��û������

	@SuppressWarnings("unused")
	@Override
	//Ȩ�޹���
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		String username = principals.toString();
		int userId = sysUserService.findUser(username).getUserid();
		SysUser user = sysUserService.findUserById(userId);
		if(user!=null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			for(SysRole role:sysUserService.findRole(userId)){
				info.addRole(role.getRole_key());//����ɫ�ı������role�У������Ҫ��Ŀ����ٻ�
				for(SysAuthority permission:sysUserService.findPremission(role.getRole_key())) {
					info.addStringPermission(permission.getData_url());//��Ȩ�ޱ������info�У������Ҫ�����Ŀ�����get
				}
				
			}
			return info;
		}else {
		return null;
		}
	}

	@SuppressWarnings("unused")
	@Override
	//��½����
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;//���token��controller�㴫���token
		/*
		 * System.out.println(token.getUsername());
		 * System.out.println(token.getPassword());
		 */
		SysUser user = sysUserService.findUser(token.getUsername());//ȡ��controller�д���token�б�����û������������һ���û���Ϣ
		ByteSource salt = ByteSource.Util.bytes(user.getSalt());//�õ����û���������ֵ
		if(user != null) {
			return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),salt,this.getName());//SimpleAuthenticationInfo��������֤ǰ̨������û��������Ƿ�ƥ��ģ������ĸ�������������������ÿɰٶ�
		}
		return null;
	}
	


	

}
