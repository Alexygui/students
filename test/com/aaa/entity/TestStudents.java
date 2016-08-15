package com.aaa.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestStudents {
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
		//创建sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build()); 
		//创建session对象
		Session session = sessionFactory.getCurrentSession();
		//创建SchemaExport对象
		SchemaExport schemaExport = new SchemaExport(configuration);
		
		schemaExport.create(true, true);
	}
}
