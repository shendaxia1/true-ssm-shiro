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
	 * 用户登陆控制器
	 * @param username用户名
	 * @param password密码
	 * @throws IOException
	 */
	@RequestMapping("/login")
	@ResponseBody 
	public void checkLogin(String username, String password) throws IOException {
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isAuthenticated()) {
			try {
			//使用shiro来进行验证
			currentUser.login(token);
			}
			/* result.put("sucess", true); */
			catch (AuthenticationException e) {
				result.setSuccess(false);
				result.setMessage("登录失败");
				super.writeJSON(result);
				return;
				}
		} 
		String name = (String)SecurityUtils.getSubject().getPrincipal();//去得到SimpleAuthenticationInfo的第一个参数，我们这里就是用户名
		SysUser user = sysUserService.findUser(name);
		if(user.getFlat()==0) {
			result.setSuccess(false);
			result.setMessage("员工已离职");
			super.writeJSON(result);
			return;
		}
		result.setSuccess(true);
		result.setMessage("登录成功");
		super.writeJSON(result);
		return;
		
	}
	/**
	 * 添加用户控制层方法
	 * @param user传入一个用户对象
	 * @throws IOException 
	 */
	@RequestMapping("/addUser")
	public void addUser(SysUser user,String role) throws IOException {
		if(user.getUsername()!=null&&user.getPassword()!=null) {//判断前台传入的用户名密码是否为空
		user.setFlat(1);
		String salt = Double.toString(Math.random());//自己生成盐值
		user.setSalt(salt);
		String password = SaltMD5.md5(user.getPassword(), salt);//加密后的密码保存到数据库
		user.setPassword(password);
		sysUserService.addUser(user);
		}else {
			result.setMessage("用户名或密码不能为空");
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
			result.setMessage("请添加用户角色");
			super.writeJSON(result);
			return;
		}
		result.setSuccess(true);
		result.setMessage("添加用户成功");
		super.writeJSON(result);
		return;
	}
	/**
	 * 员工离职操作控制层方法
	 * @param userId传入用户id
	 * @throws IOException 
	 */
	
	  @RequestMapping("/deleteUser") 
	  public void deleteUser(int userId) throws IOException {
	  
		  sysUserService.deleteUser(userId);
		  result.setSuccess(true);
		  result.setMessage("删除成功");
		  super.writeJSON(result);
		  return;
	  }
	  /**
	   * 修改员工信息控制层方法
	   * @param user
	   * @throws IOException
	   */
	  
	  @RequestMapping("/updateUser")
	  public void updateUser(SysUser user) throws IOException {
		  sysUserService.updateUser(user);
		  result.setSuccess(true);
		  result.setMessage("修改员工信息成功");
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
		  result.setMessage("添加成功");
		  return;
		  
	  }
}
