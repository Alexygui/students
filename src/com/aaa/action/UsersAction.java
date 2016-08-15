package com.aaa.action;

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
			return "login_success";
		} else {
			return "login_failure";
		}
	}
	
	@Override
	public Users getModel() {
		return user;
	}

}
