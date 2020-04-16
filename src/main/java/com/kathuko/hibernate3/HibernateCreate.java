package com.kathuko.hibernate3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateCreate {

	public static void main(String[] args) {
		UserDetails3 user1 = new UserDetails3();
		user1.setUserName("Vivek");

		UserAddress homeAddress = new UserAddress();
		homeAddress.setState("Karnataka");
		homeAddress.setCity("Bangalore");
		homeAddress.setStreet("Race Course Road");
		homeAddress.setPincode(560001);

		UserAddress officeAddress = new UserAddress();
		officeAddress.setState("Karnataka");
		officeAddress.setCity("Bangalore");
		officeAddress.setStreet("Bellandur");
		officeAddress.setPincode(560032);

		user1.setHomeAddress(homeAddress);
		user1.setOfficeAddress(officeAddress);
		Configuration con = new Configuration().configure("hibernate3.cfg.xml").addAnnotatedClass(UserDetails3.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		ses.save(user1);

		trans.commit();

	}

}
