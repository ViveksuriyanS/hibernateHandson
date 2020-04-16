package com.kathuko.hibernate1;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateCreate {

	public static void main(String[] args) {
		UserDetails1 user1 = new UserDetails1();
//		user1.setUserId(1); @GeneratedValue will assign
		user1.setUserName("Vivek");
		user1.setJoinedDate(new Date());
		user1.setLastDate(new Date());
		user1.setExperience("Accenture, Sage Intacct, TekSystems, Accolite");
		Configuration con = new Configuration().configure("hibernate1.cfg.xml").addAnnotatedClass(UserDetails1.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		ses.save(user1);

		trans.commit();

	}

}
