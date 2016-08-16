package com.aaa.entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestStudents {
	
	//创建Students和Users两张表
	@Test
	public void testSchemaExport() {
//		//创建配置对象
//		Configuration configuration = new Configuration();
//		//创建创建注册服务对象
//		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//		//创建sessionFactory
//		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		//创建配置对象
		Configuration configuration = new Configuration().configure(); 
//		//创建sessionFactory
//		SessionFactory sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build()); 
//		//创建session对象
//		Session session = sessionFactory.getCurrentSession();
		//创建SchemaExport对象
		SchemaExport schemaExport = new SchemaExport(configuration);
		
		schemaExport.create(true, true);
//		sessionFactory.close();
	}
	
	//添加测试数据
	@Test
	public void testSaveStudents() {
		//创建配置对象
		Configuration configuration = new Configuration().configure();
		//创建sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
		//创建session对象
		Session session = sessionFactory.getCurrentSession();
		//创建事务对象
		Transaction transaction = session.beginTransaction();
		Students s1 = new Students("s0000001", "张三丰", "男", new Date(), "武当山顶");
		Students s2 = new Students("s0000002", "张四丰", "男", new Date(), "武当山腰");
		Students s3 = new Students("s0000003", "张三凤", "女", new Date(), "武当山脚");
		session.save(s1);
		session.save(s2);
		session.save(s3);
		transaction.commit();
		sessionFactory.close();
	}
	
}
