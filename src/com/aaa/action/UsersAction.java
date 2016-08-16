package com.aaa.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.aaa.entity.Users;
import com.aaa.service.UsersDao;
import com.aaa.service.implement.UsersDaoImplement;
import com.opensymphony.xwork2.ModelDriven;

public class UsersAction extends SuperAction implements ModelDriven<Users>{

	private static final long serialVersionUID = 1L;

	private Users user = new Users();
	
	// 用户登录动作
	public String login() {
		UsersDao usersDao = new UsersDaoImplement();
		if(usersDao.usersLogin(user)) {
			//在session中保存登录成功的用户名
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		} else {
			return "login_failure";
		}
	}
	
	@Override
	public Users getModel() {
		return user;
	}

	//用户注销方法，加上注解取消此方法的表单验证
	@SkipValidation
	public String logout() {
		if(session.getAttribute("loginUserName") != null) {
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}

	//验证表单的方法，对于action的所有方法都要验证，所以不需要验证的需要加上注解
	//<result name="input">/users/Users_login.jsp</result>，struts.xml中需加上这句
	@Override
	public void validate() {
		//用户名不能为空的验证
		if("".equals(user.getUsername().trim())) {
			this.addFieldError("usernameError", "用户名不能为空");
		}
		if(user.getPassword().length() < 6) {
			this.addFieldError("passwordError", "密码不能小于6位");
		}
	}
	
}
