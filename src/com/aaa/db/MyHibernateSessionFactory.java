package com.aaa.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class MyHibernateSessionFactory {
	private static SessionFactory sessionFactory;//会话工厂属性

	//单例模式下，构造器为private
	private MyHibernateSessionFactory() {}
	//静态方法创建单例的sessionFactory
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build());
			return sessionFactory;
		} else {
			return sessionFactory;
		}
	}
}
