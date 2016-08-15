package com.aaa.service.implement;

import org.junit.Assert;
import org.junit.Test;

import com.aaa.entity.Users;
import com.aaa.service.UsersDao;

/**
 * 测试UsersDaoImplement类
 */
public class TestUsersDaoImplement {
	@Test
	public void testUserLogin() {
		Users user = new Users(1, "zhangsan", "123");
		UsersDao usersDao = new UsersDaoImplement();
		Assert.assertEquals(true, usersDao.usersLogin(user));
	}
}
