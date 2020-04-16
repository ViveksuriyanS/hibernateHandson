package com.kathuko.hqlParameterBinding_SQLInjection;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Create {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Configuration con = new Configuration().configure("HQLIntro.cfg.xml").addAnnotatedClass(MarvelCharacters.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		// This string can be misused and some attack can be done with different query
		String minId = "5";
//		String minId = "5 or 1=1";

		// Select * from MarvelCharacters where id < X
		Query query = ses.createQuery("from MarvelCharacters where id < " + minId);
		@SuppressWarnings("unchecked")
		List<String> chars = query.getResultList();
		System.out.println(chars);

		// Using ?Index and setParameter
		String xminId = "5";
		Query query1 = ses.createQuery("from MarvelCharacters where id < ?1");
		query1.setParameter(1, Integer.parseInt(xminId));
		@SuppressWarnings("unchecked")
		List<String> chars1 = query1.getResultList();
		System.out.println(chars1);

		// Using :name and setParameter
		String yminId = "5";
		Query query2 = ses.createQuery("from MarvelCharacters where id < :minId");
		query2.setParameter("minId", Integer.parseInt(yminId));
		@SuppressWarnings("unchecked")
		List<String> chars2 = query2.getResultList();
		System.out.println(chars2);

		trans.commit();
	}

}
