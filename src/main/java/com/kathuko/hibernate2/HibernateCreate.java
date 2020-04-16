package com.kathuko.hibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateCreate {

	public static void main(String[] args) {
		UserDetails2 user1 = new UserDetails2();
		user1.setUserName("Vivek");

		UserAddress userAddress = new UserAddress();
		userAddress.setState("Karnataka");
		userAddress.setCity("Bangalore");
		userAddress.setStreet("Race Course Road");
		userAddress.setPincode(560001);

		user1.setUserAddress(userAddress);
		Configuration con = new Configuration().configure("hibernate2.cfg.xml").addAnnotatedClass(UserDetails2.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		ses.save(user1);

		trans.commit();

	}

}
