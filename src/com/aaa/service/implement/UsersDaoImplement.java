package com.aaa.service.implement;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aaa.db.MyHibernateSessionFactory;
import com.aaa.entity.Users;
import com.aaa.service.UsersDao;

/**
 * 用户实体类，查询登录用户是否存在
 */
public class UsersDaoImplement implements UsersDao{

	@Override
	public boolean usersLogin(Users user) {
		Transaction transaction = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			hql = "from Users where username=? and password=? ";
			Query query = session.createQuery(hql);
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPassword());
			List userList = query.list();
			transaction.commit();
			if(userList.size() > 0) {
				return true;
			} else {
				return false;
			}
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}finally {
			if(transaction != null) {
				//transaction.commit();
				transaction = null;
			}
		}
	}

}
