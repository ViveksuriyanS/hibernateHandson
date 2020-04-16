package com.kathuko.hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();
		user1.setUserId(1);
		user1.setUserName("Vivek");

		Configuration con = new Configuration().configure("hibernate1.cfg.xml").addAnnotatedClass(UserDetails.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		ses.save(user1);

		trans.commit();

	}

}
