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

	//添加学生的方法
	@Override
	public boolean addStudents(Students student) {
		student.setSid(getNewSid());//设置学生的学号
		Transaction transaction = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			if(transaction != null) {
				transaction = null;
			}
		}
	}

	@Override
	public boolean updateStudents(Students student) {
		return false;
	}

	//删除学生的方法
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
	
	//生成学生的学号
	private String getNewSid() {
		Transaction transaction = null;
		String hql = "";
		String sid = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			//获得当前学生的最大编号
			hql = "select max(sid) from Students ";
			Query query = session.createQuery(hql);
			sid = (String) query.uniqueResult();//获得返回的唯一对象，转为String类型
			if(null == sid || "".equals(sid)) {
				//设定默认最大值
				sid = "S0000001";
			} else {
				String temp = sid.substring(1);//取学号的后七位字符
				int tempInt = Integer.parseInt(temp);//将学号的后七位字符转成数字
				tempInt++;
				temp = String.valueOf(tempInt);//还原成字符串
				int length = temp.length();
				//将字符串凑够七位数
				for(int i= 0; i< 7-length; i++ ) {
					temp = "0" + temp;
				}
				sid = "S" + temp;
			}
			transaction.commit();
			return sid;
		} catch (Exception e) {
			e.printStackTrace();
			return sid;
		} finally {
			if(transaction != null) {
				transaction = null;
			}
		}		
	}
}
