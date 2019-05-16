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
	 *///注意这里只能注入接口，因为shiro的是比springmvc先加载的所以如果直接注入类的话就会有找不到依赖的错误，因为执行到这的时候还没有bean还没有生成

	@SuppressWarnings("unused")
	@Override
	//权限管理
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		String username = principals.toString();
		int userId = sysUserService.findUser(username).getUserid();
		SysUser user = sysUserService.findUserById(userId);
		if(user!=null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			for(SysRole role:sysUserService.findRole(userId)){
				info.addRole(role.getRole_key());//将角色的编码放入role中，如果需要别的可以再换
				for(SysAuthority permission:sysUserService.findPremission(role.getRole_key())) {
					info.addStringPermission(permission.getData_url());//将权限编码放入info中，如果需要其他的可以再get
				}
				
			}
			return info;
		}else {
		return null;
		}
	}

	@SuppressWarnings("unused")
	@Override
	//登陆管理
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;//这个token是controller层传入的token
		/*
		 * System.out.println(token.getUsername());
		 * System.out.println(token.getPassword());
		 */
		SysUser user = sysUserService.findUser(token.getUsername());//取出controller中传入token中保存的用户名，并查出来一条用户信息
		ByteSource salt = ByteSource.Util.bytes(user.getSalt());//得到该用户的密码盐值
		if(user != null) {
			return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),salt,this.getName());//SimpleAuthenticationInfo是用于验证前台传入得用户名密码是否匹配的，包含四个参数，具体参数的作用可百度
		}
		return null;
	}
	


	

}
