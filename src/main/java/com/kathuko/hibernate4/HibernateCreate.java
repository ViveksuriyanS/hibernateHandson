package com.kathuko.hibernate4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateCreate {

	public static void main(String[] args) {
		UserDetails4 user1 = new UserDetails4();
		user1.setUserName("Vivek");

		LoginId login = new LoginId();
		login.setEmailId("vivekxyz@gmail.com");
		login.setMobileNo("9876543210");
		login.setLoginId("login1");

		user1.setUserId(login);

		Configuration con = new Configuration().configure("hibernate4.cfg.xml").addAnnotatedClass(UserDetails4.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		ses.save(user1);

		trans.commit();

	}

}
