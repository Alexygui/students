package com.aaa.service.implement;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aaa.db.MyHibernateSessionFactory;
import com.aaa.entity.Students;
import com.aaa.service.StudentsDao;

//学生业务逻辑接口的实现类
public class StudentsDaoImplement implements StudentsDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Students> queryAllStudents() {
		Transaction transaction = null;
		List<Students> studentsList = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			hql = "from Students ";
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			studentsList = query.list();
			transaction.commit();
			return studentsList;
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.commit();
			return studentsList;
		} finally {
			if(transaction != null) {
				transaction = null;
			}
		}
	}

	@Override
	public Students queryStudentsBySid(String sid) {
		return null;
	}

	@Override
	public boolean addStudents(Students student) {
		return false;
	}

	@Override
	public boolean updateStudents(Students student) {
		return false;
	}

	@Override
	public boolean deleteStudents(String sid) {
		Transaction transaction = null;
//		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			//用hibernate的get方法取得对应的Students对象并删除
			Students student = (Students) session.get(Students.class, sid);
			session.delete(student);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.commit();
			return false;
		} finally {
			if(transaction != null) {
				transaction = null;
			}
		}
	}

}
