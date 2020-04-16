package com.kathuko.hibernate5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateCreate {

	public static void main(String[] args) {
		UserDetails5 user1 = new UserDetails5();
		user1.setUserName("Vivek");

		UserAddress company1 = new UserAddress();
		company1.setState("Karnataka");
		company1.setCity("Bangalore");
		company1.setStreet("Kengeri");
		company1.setPincode(560068);

		UserAddress company2 = new UserAddress();
		company2.setState("Karnataka");
		company2.setCity("Bangalore");
		company2.setStreet("Race Course Road");
		company2.setPincode(560001);

		UserAddress company3 = new UserAddress();
		company3.setState("Karnataka");
		company3.setCity("Bangalore");
		company3.setStreet("Bellandur");
		company3.setPincode(560032);

		user1.getListOfAddress().add(company1);
		user1.getListOfAddress().add(company2);
		user1.getListOfAddress().add(company3);

		Configuration con = new Configuration().configure("hibernate5.cfg.xml").addAnnotatedClass(UserDetails5.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		ses.save(user1);

		trans.commit();

	}

}
