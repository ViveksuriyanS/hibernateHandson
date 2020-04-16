package com.kathuko.E2_OnetoMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateRead {

	public static void main(String[] args) {
		UserOnetoMany user1 = new UserOnetoMany();

		Configuration con = new Configuration().configure("hibernate7.cfg.xml").addAnnotatedClass(UserOnetoMany.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		user1 = ses.get(UserOnetoMany.class, 1);
		System.out.println(user1);

		trans.commit();

	}

}
