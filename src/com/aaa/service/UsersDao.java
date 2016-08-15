package com.aaa.service;

import com.aaa.entity.Users;

/**
 * 用户业务逻辑的接口
 */
public interface UsersDao {
	//用户登录方法
	public boolean usersLogin(Users user);
}
