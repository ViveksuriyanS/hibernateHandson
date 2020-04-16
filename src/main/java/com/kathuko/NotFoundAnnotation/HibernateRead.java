package com.kathuko.NotFoundAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateRead {

	public static void main(String[] args) {
		Vehicle vx = new Vehicle();
		Configuration con = new Configuration().configure("NotFoundAnnotation.cfg.xml")
				.addAnnotatedClass(UserNotFound.class).addAnnotatedClass(Vehicle.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		UserNotFound user = ses.get(UserNotFound.class, 1);
		System.out.println(user);
		vx = ses.get(Vehicle.class, 4791);

		System.out.println(vx.getUser());

		trans.commit();

	}

}
