package com.kathuko.hibernate5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateRead {

	public static void main(String[] args) {
		UserDetails5 user1 = new UserDetails5();

		Configuration con = new Configuration().configure("hibernate1.cfg.xml").addAnnotatedClass(UserDetails5.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		user1 = ses.get(UserDetails5.class, 1);
		System.out.println(user1);

		trans.commit();

	}

}
