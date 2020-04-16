package com.kathuko.E1_OnetoOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateRead {

	public static void main(String[] args) {
		UserOnetoOne user1 = new UserOnetoOne();

		Configuration con = new Configuration().configure("E1_OnetoOne.cfg.xml").addAnnotatedClass(UserOnetoOne.class)
				.addAnnotatedClass(VehicleX.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		user1 = ses.get(UserOnetoOne.class, 1);
		System.out.println(user1);

		trans.commit();

	}

}
